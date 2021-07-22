package com.sparta.eng87.finalproject.entitiesTest;

import com.sparta.eng87.finalproject.entities.DisciplineEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DisciplineEntityTests {

    DisciplineEntity disciplineEntity;

    @BeforeEach
    void setup() {
        disciplineEntity = new DisciplineEntity("Java SDET", 12);
    }

    @Test
    public void shouldReturnId() {
        disciplineEntity.setDiscipline_id(1);
        Assertions.assertEquals(1, disciplineEntity.getDiscipline_id());
    }

    @Test
    public void shouldReturnDisciplineName() {
        Assertions.assertEquals("Java SDET" ,disciplineEntity.getDiscipline_name());
    }

    @Test
    public void shouldReturnDevOps() {
        disciplineEntity.setDiscipline_name("DevOps");
        Assertions.assertEquals("DevOps", disciplineEntity.getDiscipline_name());
    }

    @Test
    public void shouldReturn12() {
        Assertions.assertEquals(12, disciplineEntity.getDiscipline_duration());
    }

    @Test
    public void shouldReturn14() {
        disciplineEntity.setDiscipline_duration(14);
        Assertions.assertEquals(14, disciplineEntity.getDiscipline_duration());
    }
}
