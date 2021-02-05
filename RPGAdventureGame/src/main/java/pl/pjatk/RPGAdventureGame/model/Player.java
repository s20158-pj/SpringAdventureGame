package pl.pjatk.RPGAdventureGame.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.LinkedHashSet;
import java.util.List;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int health;
    private int attack;
    private int mana;
    private int money;
    private int experience;
//    private List<String> equipment;
//    private Set<String> spells;
    private int xCoor;
    private int yCoor;

    public Player() {
    }

    public Player(String name, int health, int attack, int mana, int money, int experience, int xCoor, int yCoor) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.mana = mana;
        this.money = money;
        this.experience = experience;
        this.xCoor = xCoor;
        this.yCoor = yCoor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    //    public List<String> getEquipment() {
//        return equipment;
//    }
//
//    public void setEquipment(List<String> equipment) {
//        this.equipment = equipment;
//    }
//
//    public LinkedHashSet<String> getSpells() {
//        return spells;
//    }
//
//    public void setSpells(LinkedHashSet<String> spells) {
//        this.spells = spells;
//    }

    public int getxCoor() {
        return xCoor;
    }

    public void setxCoor(int xCoor) {
        this.xCoor = xCoor;
    }

    public int getyCoor() {
        return yCoor;
    }

    public void setyCoor(int yCoor) {
        this.yCoor = yCoor;
    }
}
