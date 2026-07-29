package Day2.copy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Playlist {
	private List<String> tracks = new ArrayList<>();

	public List<String> getTracks() {
		return Collections.unmodifiableList(tracks);
	}

//	public void setTracks(List<String> tracks) {
//		this.tracks = tracks;
//	}
	public void setTracks(List<String> tracks) {
	this.tracks = new ArrayList<>(tracks);
}

}
