package main;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.TagException;




public interface TagAnalyserInterface{
	ObtainedTags tags = new ObtainedTags();
	
	 ObtainedTags getObtainedTags();
	
	void getTagsInFile(File file) throws CannotReadException, IOException, TagException, ReadOnlyFileException, InvalidAudioFrameException;
	

}


