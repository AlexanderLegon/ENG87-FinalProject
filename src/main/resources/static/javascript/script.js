jQuery(function ($) {
    $('.table').footable();
});

function showPage() {
    document.getElementsByClassName("loader")[0].style.display = "none";
    document.getElementsByClassName("sch-wrapper")[0].style.display = "block";
};


function updateNumberOfTrainers() {
    let prevNumberOfTrainers = 1;
    let numOfTrainers = 1;
    document.body.addEventListener("click", function () {
        prevNumberOfTrainers = numOfTrainers;
        numOfTrainers = parseInt(document.getElementsByClassName("input-number")[0].value);
        console.log(numOfTrainers);
        console.log(prevNumberOfTrainers);

        addTrainersForms(numOfTrainers - prevNumberOfTrainers);

    });
}

function addTrainersForms(trainersFormsToAdd) {
    var trainersNode = document.getElementById("trainers");
    if (trainersFormsToAdd > 0) {
        let ids = ["trainer_id", "trainer_start_week", "trainer_end_week"];
        var position = trainersNode.childElementCount;
        for (var i = 0; i < trainersFormsToAdd; i++) {
            var currentPos = (position + i).toString();

            var node = document.createElement("div");
            node.className = "row";

            for (var j = 0; j < 3; j++) {
                currentId = ids[j] + currentPos;
                var colNode = document.createElement("div");
                colNode.className = "col";

                var labelNode = document.createElement("label");
                labelNode.htmlFor = currentId;
                labelNode.className = "form-label";

                var inputNode = document.createElement("input");
                inputNode.type = "number";
                inputNode.id = currentId;
                inputNode.name = currentId;
                inputNode.className = "form-control";

                if (j != 0) {
                    inputNode.value = "1";
                    inputNode.min = "1";
                    inputNode.max = "52";
                }

                colNode.appendChild(labelNode);
                colNode.appendChild(inputNode);
                node.appendChild(colNode);
            }


            trainersNode.appendChild(node);
        }
    } else {
        for (var i = 0; i > trainersFormsToAdd; i--) {
            trainersNode.removeChild(trainersNode.lastChild);
        }
    }
}

window.onload = function () {
    updateNumberOfTrainers();

    $('.btn-number').click(function (e) {
        e.preventDefault();

        fieldName = $(this).attr('data-field');
        type = $(this).attr('data-type');
        var input = $("input[name='" + fieldName + "']");
        var currentVal = parseInt(input.val());
        if (!isNaN(currentVal)) {
            if (type == 'minus') {

                if (currentVal > input.attr('min')) {
                    input.val(currentVal - 1).change();
                }
                if (parseInt(input.val()) == input.attr('min')) {
                    $(this).attr('disabled', true);
                }

            } else if (type == 'plus') {

                if (currentVal < input.attr('max')) {
                    input.val(currentVal + 1).change();
                }
                if (parseInt(input.val()) == input.attr('max')) {
                    $(this).attr('disabled', true);
                }

            }
        } else {
            input.val(0);
        }
    });
    $('.input-number').focusin(function () {
        $(this).data('oldValue', $(this).val());
    });
    $('.input-number').change(function () {

        minValue = parseInt($(this).attr('min'));
        maxValue = parseInt($(this).attr('max'));
        valueCurrent = parseInt($(this).val());

        name = $(this).attr('name');
        if (valueCurrent >= minValue) {
            $(".btn-number[data-type='minus'][data-field='" + name + "']").removeAttr('disabled')
        } else {
            alert('Sorry, the minimum value was reached');
            $(this).val($(this).data('oldValue'));
        }
        if (valueCurrent <= maxValue) {
            $(".btn-number[data-type='plus'][data-field='" + name + "']").removeAttr('disabled')
        } else {
            alert('Sorry, the maximum value was reached');
            $(this).val($(this).data('oldValue'));
        }


    });
    $(".input-number").keydown(function (e) {
        // Allow: backspace, delete, tab, escape, enter and .
        if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 190]) !== -1 ||
            // Allow: Ctrl+A
            (e.keyCode == 65 && e.ctrlKey === true) ||
            // Allow: home, end, left, right
            (e.keyCode >= 35 && e.keyCode <= 39)) {
            // let it happen, don't do anything
            return;
        }
        // Ensure that it is a number and stop the keypress
        if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
            e.preventDefault();
        }
    });
}