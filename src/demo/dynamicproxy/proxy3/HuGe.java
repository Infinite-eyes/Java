package demo.dynamicproxy.proxy3;


public class HuGe implements Star {

    @Override
    public void sing(String song) {
        System.out.println("胡歌演唱： " + song);
    }

    @Override
    public String act(String teleplay) {
        System.out.println("胡歌决定出演电视剧： " + teleplay);
        return "胡歌答应出演电视剧： " + teleplay;
    }
}
