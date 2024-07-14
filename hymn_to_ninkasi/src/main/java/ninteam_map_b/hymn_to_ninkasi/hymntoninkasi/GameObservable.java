package ninteam_map_b.hymn_to_ninkasi.hymntoninkasi;

public interface GameObservable {
    
    /**
     *
     * @param o
     */
    public void attach(GameObserver o);
    
    /**
     *
     * @param o
     */
    public void detach(GameObserver o);
    
    /**
     *
     */
    public void notifyObservers();
    
}
