package com.parabolt.academyHackaton.back1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.parabolt.academyHackaton.back1.request.QuestRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Quest {
	
	public Quest(QuestRequest quest){
		this.title = quest.getTitle();
		this.body = quest.getBody();
		this.adventure=quest.getAdventure();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	
	@Column
	private String title;
	
	@Column
	private String body;
	
	@Column
	private String adventure;	
	
}
