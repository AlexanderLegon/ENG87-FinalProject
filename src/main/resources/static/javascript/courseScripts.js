var location_id = document.getElementById("location_id");
var inputButton = document.getElementById("inputButton")

function exceedsCapacity() {
    return confirm("Are you sure you wish to proceed " + location_id.valueOf());
}

inputButton.addEventListener("click", function () {
    return confirm("Are you sure you wish to proceed " + location_id.valueOf());
})