package com.jspiders.musicplayerhibernate.songoperation;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspiders.musicplayerhibernate.song.Song;

public class SongDriver {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Scanner sc = new Scanner(System.in);
	private static Query query;
	private static String jpqlQuery;
	

	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("song");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}

	private static void closeConnection() {
		if (factory != null) {
			factory.close();
		}
		if(manager != null) {
			manager.close();
		}
		if(transaction.isActive()) {
			transaction.rollback();
		}
	}

	public void addSong() {
		try {
			System.out.println("******************* ADD SONG ************************");
			openConnection();
			
			transaction.begin();
			boolean loop = true;
			while (loop) {
				Song song = new Song();
				System.out.print("Enter Song Name : ");
				song.setSongName(sc.next());
				System.out.print("Enter Song Duration : ");
				song.setSongDuration(sc.nextDouble());
				System.out.print("Enter Singer Name : ");
				song.setSingerName(sc.next());
				System.out.print("Enter Album Name : ");
				song.setAlbumName(sc.next());
				
				manager.persist(song);
				
				transaction.commit();
				System.out.println(" Song added ");
				
				/*
				 * System.out.println(" 1. Add Next Song \n 2. Go back "); int input =
				 * sc.nextInt(); if (input == 2) {
				 * 
				 * loop = false;
				 * System.out.println("Going Back \n ______________________________"); }
				 */
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Invalid input or duplicate id");
		} 
		finally {
			closeConnection();
		}
	}

	public void getSong() {
		try {
			openConnection();
			
			transaction.begin();
			
			jpqlQuery = "from song";
			query = manager.createQuery(jpqlQuery);
			List <Song> songs = query.getResultList();
			if (songs.isEmpty()) {
				System.out.println("Opps !! No Song is avilable... Please add song first");
			} else {
				System.out.println("********************* PLAY All *********************** \n Playing all Song");
				for(Song s : songs)
				System.out.println(s);
				
				System.out.println(" 1. Go home ");
				int input = sc.nextInt();
				if (input == 1) {
					System.out.println("Going Home page");
				}
			}
			
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			transaction.commit();
			closeConnection();
		}

	}

//	public void chooseSong() {
//		try {
//			openConnection();
//			System.out.println("____ Select Song ___");
//
//			preparedStatement = connection.prepareStatement(properties.getProperty("selectQuery"));
//
//			resultSet = preparedStatement.executeQuery();
//			
//			//JDBC Object implementation
//			while (resultSet.next()) {
//				song = new Song();
//				song.setSongId(resultSet.getInt(1));
//				song.setSongName(resultSet.getString(2));
//				song.setSongDuration(resultSet.getDouble(3));
//				song.setSingerName(resultSet.getString(4));
//				song.setAlbumName(resultSet.getString(5));
//				
//				System.out.println(song);
//			}
//
//
//			System.out.println("Enter Song Name : ");
//			
//			preparedStatement = connection.prepareStatement(properties.getProperty("searchQuery"));
//			preparedStatement.setString(1, sc.next());
//
//			resultSet = preparedStatement.executeQuery();
//
//			if (resultSet.isBeforeFirst()) {
//				while (resultSet.next()) {
//					System.out.println(resultSet.getString(1) + " | " + resultSet.getString(2) + " | "
//							+ resultSet.getDouble(3) + " | " + resultSet.getString(4) + " | " + resultSet.getString(5));
//				}
//			} else {
//				System.out.println("Song not present");
//			}
//
//		} catch (Exception e) {
//			System.out.println("Invalid input");
//		}finally {
//			closeConnection();
//		}
//	}
//	public void deleteAll() {
//		try {
//			openConnection();
//			preparedStatement = connection.prepareStatement(properties.getProperty("truncateQuery"));
//			preparedStatement.executeUpdate();
//			
//			System.out.println("All song deleted");
//		} catch(Exception e) {
//			e.printStackTrace();
//		} finally {
//			closeConnection();
//		}
//	}
}
