package com.ariane.asdinsights.models;

import com.ariane.asdinsights.models.enums.ChildFeel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;
import java.util.UUID;


@Entity
@Table(name = "TB_REPORTS")
public class ReportModel extends RepresentationModel<ReportModel> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid")
    private UUID idUser;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDate datePost;
    private Integer dayRating;
    private Integer socialInteraction;
    private Integer anxiety;
    private Integer pleasant;
    private Integer impatience;
    private Integer aggressiveness;
    private Integer friendliness;
    private Integer communication;
    private Integer concentration;
    private ChildFeel emotion;

    public UUID getIdUser() {
        return idUser;
    }

    public void setIdUser(UUID idUser) {
        this.idUser = idUser;
    }

    public LocalDate getDatePost() {
        return datePost;
    }

    public void setDatePost(LocalDate datePost) {
        this.datePost = datePost;
    }

    public Integer getDayRating() {
        return dayRating;
    }

    public void setDayRating(Integer dayRating) {
        this.dayRating = dayRating;
    }

    public Integer getSocialInteraction() {
        return socialInteraction;
    }

    public void setSocialInteraction(Integer socialInteraction) {
        this.socialInteraction = socialInteraction;
    }

    public Integer getAnxiety() {
        return anxiety;
    }

    public void setAnxiety(Integer anxiety) {
        this.anxiety = anxiety;
    }

    public Integer getPleasant() {
        return pleasant;
    }

    public void setPleasant(Integer pleasant) {
        this.pleasant = pleasant;
    }

    public Integer getImpatience() {
        return impatience;
    }

    public void setImpatience(Integer impatience) {
        this.impatience = impatience;
    }

    public Integer getAggressiveness() {
        return aggressiveness;
    }

    public void setAggressiveness(Integer aggressiveness) {
        this.aggressiveness = aggressiveness;
    }

    public Integer getFriendliness() {
        return friendliness;
    }

    public void setFriendliness(Integer friendliness) {
        this.friendliness = friendliness;
    }

    public Integer getCommunication() {
        return communication;
    }

    public void setCommunication(Integer communication) {
        this.communication = communication;
    }

    public Integer getConcentration() {
        return concentration;
    }

    public void setConcentration(Integer concentration) {
        this.concentration = concentration;
    }

    public ChildFeel getEmotion() {
        return emotion;
    }

    public void setEmotion(ChildFeel emotion) {
        this.emotion = emotion;
    }
}
