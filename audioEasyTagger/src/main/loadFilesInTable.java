package main;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.TagException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class loadFilesInTable {

	public  loadFilesInTable(ObtainedTags tags,File selectedFile, JTable table, JScrollPane scrollPane, 
			JScrollPane scrollPane_Albums, JScrollPane scrollPane_Genres,  JScrollPane scrollPane_Artists,  
			JLabel lblNewLabel_1, JList listAlbums, JList listArtists, JList listGenres ) throws ReadOnlyFileException, CannotReadException, IOException, TagException, InvalidAudioFrameException{
	 


		// here we display the Artists and the Albums in the JList
		DefaultListModel<String> listModelAlbum = new DefaultListModel();
		ArrayList<String> listOfAlbumsWithFrequencies = new ArrayList<String>();
		int i=0;
		for (String album: tags.getListOfAlbumsSortedByFrequency()){
			listOfAlbumsWithFrequencies.add(album + " (" + tags.getListOfFrequenciesAlbums().get(i) + ")" );
			listModelAlbum.add(i, album + " (" + tags.getListOfFrequenciesAlbums().get(i) + ")" );
			i++;
		}

		listAlbums.setModel(listModelAlbum);
		scrollPane_Albums.setViewportView(listAlbums);

		DefaultListModel<String> listModelArtist = new DefaultListModel();

		ArrayList<String> listOfArtistsWithFrequencies = new ArrayList<String>();
		int j=0;
		for (String artist: tags.getListOfArtistsSortedByFrequency()){
			listOfArtistsWithFrequencies.add(artist + " (" + tags.getListOfFrequenciesArtists().get(j) + ")" );
			listModelArtist.add(j, artist + " (" + tags.getListOfFrequenciesArtists().get(j) + ")" );
			j++;

		}
		listArtists.setModel(listModelArtist);
		scrollPane_Artists.setViewportView(listArtists);
		
		
		
		DefaultListModel<String> listModelGenres = new DefaultListModel();

		ArrayList<String> listOfGenresWithFrequencies = new ArrayList<String>();
		int k=0;
		for (String genre: tags.getListOfGenresSortedByFrequency()){
			listOfGenresWithFrequencies.add(genre + " (" + tags.getListOfFrequenciesGenres().get(k) + ")" );
			listModelGenres.add(k, genre + " (" + tags.getListOfFrequenciesGenres().get(k) + ")" );
			k++;

		}
		listGenres.setModel(listModelGenres);
		scrollPane_Genres.setViewportView(listGenres);



		//here we display the table
		String[] columnNames = {"File","Title","Artist","Album","Genre"};
		int numberOfFilesToTag = tags.getListOfMusicFiles().size();
		String[][] dataInJTable = new String[numberOfFilesToTag][5];
		for (int i1 =0; i1< numberOfFilesToTag; i1++) {
			dataInJTable[i1][0] = tags.getListOfMusicFiles().get(i1).getName();
			dataInJTable[i1][1] = tags.getListOfTitles().get(i1);
			dataInJTable[i1][2] = tags.getListOfArtists().get(i1);
			dataInJTable[i1][3] = tags.getListOfAlbums().get(i1);
			dataInJTable[i1][4] = tags.getListOfGenres().get(i1);
			System.out.println(tags.getListOfTitles().get(i1));
		}
		DefaultTableModel model = new DefaultTableModel(dataInJTable, columnNames);
		table.setModel(model);
		scrollPane.setViewportView(table);
	}

}
