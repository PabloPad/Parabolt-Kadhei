package com.parabolt.academyHackaton.back1.entity;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.parabolt.academyHackaton.back1.request.QuestRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Quest {
	
	public Quest(QuestRequest questRequest){
		this.title = questRequest.getTitle();
		this.body = questRequest.getBody();
		//init adventure
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	
	
	@Column
	private int stage;
	
	
	@Column
	private String title;
	
	@Column
	private String body;
	
	//prototype implementation of relational mapping for quests - adventures
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Adventure adventure;	
	
}
