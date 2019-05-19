package design.structure.adapter;

/**
 *老接口适配新功能
 */
public class ListenMusicAdapter implements Charging{
    private ListenMusic listenMusic ;
    public ListenMusicAdapter(ListenMusic listenMusic){
        this.listenMusic = listenMusic;
    }
    @Override
    public void charging() {
        listenMusic.listenMusic();
    }
}
