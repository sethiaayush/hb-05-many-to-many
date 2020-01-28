package com.sethi.aayush.hibernate.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "youtube_Channel")
	private String youTubeChannel;

	@Column(name = "hobby")
	private String hobby;

	@OneToOne(mappedBy = "instructorDetail", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	// modify the cascade type to suit your requirement.
	private Instructor instructor;

	public InstructorDetail() {
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youTubeChannel=" + youTubeChannel + ", hobby=" + hobby + "]";
	}

	public InstructorDetail(String youTubeChannel, String hobby) {
		super();
		this.youTubeChannel = youTubeChannel;
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYouTubeChannel() {
		return youTubeChannel;
	}

	public void setYouTubeChannel(String youTubeChannel) {
		this.youTubeChannel = youTubeChannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

}
