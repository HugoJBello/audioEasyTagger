package main;

import java.io.File;
import java.util.ArrayList;

public class ObtainedTags {
	ArrayList<File> listOfMusicFiles = new ArrayList<File>();
	ArrayList<String> listOfArtists = new ArrayList<String>();
	ArrayList<String> listOfAlbums = new ArrayList<String>();
	ArrayList<String>  listOfGenres = new ArrayList<String>();
	ArrayList<String>  listOfTitles = new ArrayList<String>();
	ArrayList<String> listOfArtistsSortedByFrequency = new ArrayList<String>();
	ArrayList<Integer> listOfFrequenciesArtists = new ArrayList<Integer>();
	ArrayList<String> listOfAlbumsSortedByFrequency = new ArrayList<String>();
	ArrayList<Integer> listOfFrequenciesAlbums = new ArrayList<Integer>();

	ArrayList<String> listOfGenresSortedByFrequency = new ArrayList<String>();
	ArrayList<Integer> listOfFrequenciesGenres = new ArrayList<Integer>();
	
	
	public ArrayList<File> getListOfMusicFiles() {
		return listOfMusicFiles;
	}
	public void setListOfMusicFiles(ArrayList<File> listOfMusicFiles) {
		this.listOfMusicFiles = listOfMusicFiles;
	}
	public ArrayList<String> getListOfArtists() {
		return listOfArtists;
	}
	public void setListOfArtists(ArrayList<String> listOfArtists) {
		this.listOfArtists = listOfArtists;
	}
	public ArrayList<String> getListOfAlbums() {
		return listOfAlbums;
	}
	public void setListOfAlbums(ArrayList<String> listOfAlbums) {
		this.listOfAlbums = listOfAlbums;
	}
	public ArrayList<String> getListOfGenres() {
		return listOfGenres;
	}
	public void setListOfGenres(ArrayList<String> listOfGenres) {
		this.listOfGenres = listOfGenres;
	}
	public ArrayList<String> getListOfTitles() {
		return listOfTitles;
	}
	public void setListOfTitles(ArrayList<String> listOfTitles) {
		this.listOfTitles = listOfTitles;
	}
	public ArrayList<String> getListOfArtistsSortedByFrequency() {
		return listOfArtistsSortedByFrequency;
	}
	public void setListOfArtistsSortedByFrequency(
			ArrayList<String> listOfArtistsSortedByFrequency) {
		this.listOfArtistsSortedByFrequency = listOfArtistsSortedByFrequency;
	}
	public ArrayList<Integer> getListOfFrequenciesArtists() {
		return listOfFrequenciesArtists;
	}
	public void setListOfFrequenciesArtists(
			ArrayList<Integer> listOfFrequenciesArtists) {
		this.listOfFrequenciesArtists = listOfFrequenciesArtists;
	}
	public ArrayList<String> getListOfAlbumsSortedByFrequency() {
		return listOfAlbumsSortedByFrequency;
	}
	public void setListOfAlbumsSortedByFrequency(
			ArrayList<String> listOfAlbumsSortedByFrequency) {
		this.listOfAlbumsSortedByFrequency = listOfAlbumsSortedByFrequency;
	}
	public ArrayList<Integer> getListOfFrequenciesAlbums() {
		return listOfFrequenciesAlbums;
	}
	public void setListOfFrequenciesAlbums(
			ArrayList<Integer> listOfFrequenciesAlbums) {
		this.listOfFrequenciesAlbums = listOfFrequenciesAlbums;
	}
	public ArrayList<String> getListOfGenresSortedByFrequency() {
		return listOfGenresSortedByFrequency;
	}
	public void setListOfGenresSortedByFrequency(
			ArrayList<String> listOfGenresSortedByFrequency) {
		this.listOfGenresSortedByFrequency = listOfGenresSortedByFrequency;
	}
	public ArrayList<Integer> getListOfFrequenciesGenres() {
		return listOfFrequenciesGenres;
	}
	public void setListOfFrequenciesGenres(
			ArrayList<Integer> listOfFrequenciesGenres) {
		this.listOfFrequenciesGenres = listOfFrequenciesGenres;
	}

}
