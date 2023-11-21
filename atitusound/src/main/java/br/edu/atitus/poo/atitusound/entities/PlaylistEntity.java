package br.edu.atitus.poo.atitusound.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_playlist")
public class PlaylistEntity extends GenericEntity{
	
	private boolean public_share;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tb_playlist_music",
				joinColumns = @JoinColumn(name = "playlist_uuid"),
				inverseJoinColumns = @JoinColumn(name = "music_uuid"))
	
	private List<MusicEntity> musics;

	public boolean isPublic_share() {
		return public_share;
	}

	public void setPublic_share(boolean public_share) {
		this.public_share = public_share;
	}

	public List<MusicEntity> getMusics() {
		return musics;
	}

	public void setMusics(List<MusicEntity> musics) {
		this.musics = musics;
	}
	
	
}
