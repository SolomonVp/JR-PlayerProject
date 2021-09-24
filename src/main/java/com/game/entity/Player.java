package com.game.entity;

import javax.persistence.*;
import java.util.Date;


@Entity                                                                                                                         //Указывает, что данный бин (класс) является сущностью
@Table(name = "Player")                                                                                                         //Указывает на имя таблицы, которая будет отображаться в этой сущности.
public class Player {
    @Id                                                                                                                         //Аннотацией определяем ключ
    @GeneratedValue(strategy = GenerationType.IDENTITY)                                                                         //Аннотацией добавляется к первичному ключу, указывает, что данное свойство будет создаваться согласно указанной стратегии.
    Long id;                                             // ID игрока
    String name;                                         // Имя персонажа (до 12 знаков включительно)
    String title;                                        // Титул персонажа (до 30 знаков включительно)
    @Enumerated(EnumType.STRING)                                                                                                //Таким образом, мы можем поручить поставщику JPA преобразовать перечисление в его порядковое или строковое значение.
    Race race;                                           // Расса персонажа
    @Enumerated(EnumType.STRING)                                                                                                //Таким образом, мы можем поручить поставщику JPA преобразовать перечисление в его порядковое или строковое значение.
    Profession profession;                               // Профессия персонажа
    Integer experience;                                  // Опыт персонажа. Диапазон значений 0..10,000,000
    Integer level;                                       // Уровень персонажа
    Integer untilNextLevel;                              // Остаток опыта до следующего уровня
    @Temporal(TemporalType.DATE)                                                                                                //Имитация общей концепции даты и времени
    Date birthday;                                       // Дата регистрации. Диапазон значений года 2000..3000 включительно
    Boolean banned;                                      // Забанен / не забанен

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Race getRace() {
        return race;
    }
    public void setRace(Race race) {
        this.race = race;
    }
    public Profession getProfession() {
        return profession;
    }
    public void setProfession(Profession profession) {
        this.profession = profession;
    }
    public Integer getExperience() {
        return experience;
    }
    public void setExperience(Integer experience) {
        this.experience = experience;
    }
    public Integer getLevel() {
        return level;
    }
    public void setLevel(Integer level) {
        this.level = level;
    }
    public Integer getUntilNextLevel() {
        return untilNextLevel;
    }
    public void setUntilNextLevel(Integer untilNextLevel) {
        this.untilNextLevel = untilNextLevel;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public Boolean isBanned() {
        return banned;
    }
    public void setBanned(Boolean banned) {
        this.banned = banned;
    }
}
