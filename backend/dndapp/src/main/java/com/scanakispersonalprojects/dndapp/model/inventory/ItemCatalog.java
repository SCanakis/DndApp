package com.scanakispersonalprojects.dndapp.model.inventory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.scanakispersonalprojects.dndapp.model.basicCharInfo.AbilityScore;
import com.scanakispersonalprojects.dndapp.model.basicCharInfo.RollType;


@Entity
@Table(name = "item_catalog")
public class ItemCatalog {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "item_uuid", columnDefinition = "UUID")
    private UUID itemUuid;

    @Column(name = "item_name", length = 50, nullable = false, unique = true)
    private String itemName;

    @Column(name="item_description", columnDefinition = "TEXT", nullable = false)
    private String itemDescription;

    

    @Column(name = "item_weight", nullable = false)
    private Integer itemWeight = 0;

    @Column(name = "item_value", nullable = false)
    private Integer itemValue = 0;

    @Enumerated(EnumType.STRING)
    @Column(name = "item_rarity", nullable = false)
    private Rarity itemRarity = Rarity.common;

    @Column(name = "attackable", nullable = false)
    private boolean attackable = false;



    @Column(name = "ac_bonus")
    private Short acBonus;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "add_as_to_ac", columnDefinition = "json")
    private Map<AbilityScore, Boolean> addToAc;


    @Column(name = "equippable", nullable = false)
    private boolean equippable = false;

    @Column(name = "attunable", nullable = false)
    private boolean attunable = false;

    @Column(name = "item_equippable_type", columnDefinition = "equippable_type[]")
    private List<EquippableType> itemEquippableTypes;


    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "skill_altered_roll_type")
    private Map<Skill, RollType> skillAlteredRollType;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "skill_altered_bonus")
    private Map<Skill, Integer> skillAlteredBonus;

    public ItemCatalog() {}

    public ItemCatalog(String itemName, String itemDescription, Integer itemWeight, Integer itemValue,
            Rarity itemRarity, boolean attackable, Short acBonus, Map<AbilityScore, Boolean> addToAc,
            boolean equippable, boolean attunable, List<EquippableType> itemEquippableTypes,
            Map<Skill, RollType> skillAlteredRollType, Map<Skill, Integer> skillAlteredBonus) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemWeight = itemWeight;
        this.itemValue = itemValue;
        this.itemRarity = itemRarity;
        this.attackable = attackable;
        this.acBonus = acBonus;
        this.addToAc = addToAc;
        this.equippable = equippable;
        this.attunable = attunable;
        this.itemEquippableTypes = itemEquippableTypes;
        this.skillAlteredRollType = skillAlteredRollType;
        this.skillAlteredBonus = skillAlteredBonus;
    }


    public UUID getItemUuid() {
        return itemUuid;
    }

    public void setItemUuid(UUID itemUuid) {
        this.itemUuid = itemUuid;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Integer getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(Integer itemWeight) {
        this.itemWeight = itemWeight;
    }

    public Integer getItemValue() {
        return itemValue;
    }

    public void setItemValue(Integer itemValue) {
        this.itemValue = itemValue;
    }

    public Rarity getItemRarity() {
        return itemRarity;
    }

    public void setItemRarity(Rarity itemRarity) {
        this.itemRarity = itemRarity;
    }

    public boolean isAttackable() {
        return attackable;
    }

    public void setAttackable(boolean attackable) {
        this.attackable = attackable;
    }

    public Short getAcBonus() {
        return acBonus;
    }

    public void setAcBonus(Short acBonus) {
        this.acBonus = acBonus;
    }

    public Map<AbilityScore, Boolean> getAddToAc() {
        return addToAc;
    }

    public void setAddToAc(Map<AbilityScore, Boolean> addToAc) {
        this.addToAc = addToAc;
    }

    public boolean isEquippable() {
        return equippable;
    }

    public void setEquippable(boolean equippable) {
        this.equippable = equippable;
    }

    public boolean isAttunable() {
        return attunable;
    }

    public void setAttunable(boolean attunable) {
        this.attunable = attunable;
    }

    public List<EquippableType> getItemEquippableTypes() {
        return itemEquippableTypes;
    }

    public void setItemEquippableTypes(List<EquippableType> itemEquippableTypes) {
        this.itemEquippableTypes = itemEquippableTypes;
    }

    public Map<Skill, RollType> getSkillAlteredRollType() {
        return skillAlteredRollType;
    }

    public void setSkillAlteredRollType(Map<Skill, RollType> skillAlteredRollType) {
        this.skillAlteredRollType = skillAlteredRollType;
    }

    public Map<Skill, Integer> getSkillAlteredBonus() {
        return skillAlteredBonus;
    }

    public void setSkillAlteredBonus(Map<Skill, Integer> skillAlteredBonus) {
        this.skillAlteredBonus = skillAlteredBonus;
    }

    
}
