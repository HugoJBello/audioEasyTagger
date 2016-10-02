package main;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("TagAnalyser")
public class TagAnalyser implements TagAnalyserInterface{

	private ObtainedTags obtainedTags = new ObtainedTags();


	


	//this constructor takes the inputFolder and adds all the tags in the folder to the listOfArtists and listOfAlbums. Then it sorts them and stores the frequencies.
	public  void getTagsInFile(File inputFolder) throws CannotReadException, IOException, TagException, ReadOnlyFileException, InvalidAudioFrameException {
		filesFromFolder files = new filesFromFolder(inputFolder);
		//obtainedTags.setListOfMusicFiles(files.getListOfFiles());
		
		ArrayList<String> listOfArtists = new ArrayList<String>();
		ArrayList<String> listOfAlbums = new ArrayList<String>();
		ArrayList<String>  listOfGenres = new ArrayList<String>();
		ArrayList<String>  listOfTitles = new ArrayList<String>();

		for (File file :files.getListOfFiles()){
 			//here we find out the extension of the file
			String extension = "";

			int i = file.getName().lastIndexOf('.');
			if (i > 0) {
				extension = file.getName().substring(i+1);
			}

			// here we add the tags to the corresponding lists:
			String artist= "";
			String album = "";
			String genre = "";
			String title = "";
 			if (extension.equalsIgnoreCase("mp3") || extension.equalsIgnoreCase("flac")|| extension.equalsIgnoreCase("ogg")){
				AudioFile mp3file = AudioFileIO.read(file);
				Tag tag = mp3file.getTag();
 				artist= tag.getFirst(FieldKey.ARTIST);
				album = tag.getFirst(FieldKey.ALBUM);
				genre = tag.getFirst(FieldKey.GENRE);
				title = tag.getFirst(FieldKey.TITLE);
				listOfArtists.add(artist);
				listOfAlbums.add(album);
				listOfGenres.add(genre);
				listOfTitles.add(title);
				 ArrayList<File> listOfMusicFiles = obtainedTags.getListOfMusicFiles();
				 listOfMusicFiles.add(file);
				 obtainedTags.setListOfMusicFiles(listOfMusicFiles);
			}
			



		}
		obtainedTags.setListOfArtists(listOfArtists);
		obtainedTags.setListOfAlbums(listOfAlbums);	 
		obtainedTags.setListOfGenres(listOfGenres);	 
		obtainedTags.setListOfTitles(listOfTitles);	 




		// here we sort the listOfArtists by frequencies:

		final Map<String, Integer> counter = new HashMap<String, Integer>();
		for (String str : listOfArtists)
			counter.put(str, 1 + (counter.containsKey(str) ? counter.get(str) : 0));

		ArrayList<String> listOfArtistsSortedByFrequency = new ArrayList<String>(counter.keySet());
		ArrayList<Integer> listOfFrequenciesArtists = new ArrayList<Integer>(listOfArtistsSortedByFrequency.size());

		Collections.sort(listOfArtistsSortedByFrequency, new Comparator<String>() {
			@Override
			public int compare(String x, String y) {
				return counter.get(y) - counter.get(x);
			}
		});

		for (String str : listOfArtistsSortedByFrequency) {
			int frequency = counter.get(str);
			listOfFrequenciesArtists.add(frequency);
		}
		obtainedTags.setListOfArtistsSortedByFrequency(listOfArtistsSortedByFrequency);
		obtainedTags.setListOfFrequenciesArtists(listOfFrequenciesArtists);


		// here we sort the listOfAlbums by frequencies:

		final Map<String, Integer> counter2 = new HashMap<String, Integer>();
		for (String str : listOfAlbums)
			counter2.put(str, 1 + (counter2.containsKey(str) ? counter2.get(str) : 0));

		ArrayList<String> listOfAlbumsSortedByFrequency = new ArrayList<String>(counter2.keySet());
		ArrayList<Integer>  listOfFrequenciesAlbums = new ArrayList<Integer>(listOfAlbumsSortedByFrequency.size());

		Collections.sort(listOfAlbumsSortedByFrequency, new Comparator<String>() {
			@Override
			public int compare(String x, String y) {
				return counter2.get(y) - counter2.get(x);
			}
		});

		for (String str : listOfAlbumsSortedByFrequency) {
			int frequency = counter2.get(str);
			listOfFrequenciesAlbums.add(frequency);
		}
		obtainedTags.setListOfAlbumsSortedByFrequency(listOfAlbumsSortedByFrequency);
		obtainedTags.setListOfFrequenciesAlbums(listOfFrequenciesAlbums);



		// here we sort the listOfGenres by frequencies:

		final Map<String, Integer> counter3 = new HashMap<String, Integer>();
		for (String str1 : listOfGenres)
			counter3.put(str1, 1 + (counter3.containsKey(str1) ? counter3.get(str1) : 0));

		ArrayList<String>  listOfGenresSortedByFrequency = new ArrayList<String>(counter3.keySet());
		ArrayList<Integer> listOfFrequenciesGenres = new ArrayList<Integer>(listOfGenresSortedByFrequency.size());

		Collections.sort(listOfGenresSortedByFrequency, new Comparator<String>() {
			@Override
			public int compare(String x, String y) {
				return counter3.get(y) - counter3.get(x);
			}
		});

		for (String str1 : listOfGenresSortedByFrequency) {
			int frequency = counter3.get(str1);
			listOfFrequenciesGenres.add(frequency);
		}
		obtainedTags.setListOfGenresSortedByFrequency(listOfGenresSortedByFrequency);
		obtainedTags.setListOfFrequenciesGenres(listOfFrequenciesGenres);

	}




	public ObtainedTags getObtainedTags() {
		return obtainedTags;
	}




	public void setObtainedTags(ObtainedTags obtainedTags) {
		this.obtainedTags = obtainedTags;
	}

	//getters and setters:



} 


