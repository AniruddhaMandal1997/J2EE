package com.jspiders.musicplayerhibernate.song;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name = "song")
public class Song {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int songId;
	private String songName;
	private double songDuration;
	private String singerName;
	private String albumName;
}