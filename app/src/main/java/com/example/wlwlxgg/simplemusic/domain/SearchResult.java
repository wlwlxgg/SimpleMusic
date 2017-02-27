package com.example.wlwlxgg.simplemusic.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wlwlxgg on 2017/2/27.
 */

public class SearchResult implements Serializable {

    private int error_code;
    private ResultBean result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {

        private String query;
        private String syn_words;
        private int rqt_type;
        private SongInfoBean song_info;
        private AlbumInfoBean album_info;

        public String getQuery() {
            return query;
        }

        public void setQuery(String query) {
            this.query = query;
        }

        public String getSyn_words() {
            return syn_words;
        }

        public void setSyn_words(String syn_words) {
            this.syn_words = syn_words;
        }

        public int getRqt_type() {
            return rqt_type;
        }

        public void setRqt_type(int rqt_type) {
            this.rqt_type = rqt_type;
        }

        public SongInfoBean getSong_info() {
            return song_info;
        }

        public void setSong_info(SongInfoBean song_info) {
            this.song_info = song_info;
        }

        public AlbumInfoBean getAlbum_info() {
            return album_info;
        }

        public void setAlbum_info(AlbumInfoBean album_info) {
            this.album_info = album_info;
        }

        public static class SongInfoBean {
            /**
             * total : 69
             * song_list : [{"content":"","copy_type":"1","toneid":"0","info":"","all_rate":"320,128,flac,256,192,64,24","resource_type":2,"relate_status":0,"has_mv_mobile":1,"song_id":"18401298","title":"七里香","ting_uid":"7994","author":"周杰伦","album_id":"18394691","album_title":"第五届百事音乐风云榜","is_first_publish":0,"havehigh":2,"charge":0,"has_mv":0,"learn":0,"song_source":"web","piao_id":"0","korean_bb_song":"0","resource_type_ext":"0","artist_id":"29","all_artist_id":"29","lrclink":"http://musicdata.baidu.com/data2/lrc/65094964/%E4%B8%83%E9%87%8C%E9%A6%99.lrc","data_source":0,"cluster_id":93119037},{"content":"","copy_type":"1","toneid":"600902000006889283","info":"","all_rate":"128,64,256,192,320,flac,24","resource_type":2,"relate_status":0,"has_mv_mobile":1,"song_id":"290466","title":"止战之殇.","ting_uid":"7994","author":"周杰伦","album_id":"67909","album_title":"","is_first_publish":0,"havehigh":2,"charge":0,"has_mv":1,"learn":1,"song_source":"web","piao_id":"0","korean_bb_song":"0","resource_type_ext":"0","artist_id":"29","all_artist_id":"29","lrclink":"http://musicdata.baidu.com/data2/lrc/13881596/%E6%AD%A2%E6%88%98%E4%B9%8B%E6%AE%87..lrc","data_source":0,"cluster_id":93304629}]
             */

            private int total;
            private List<SongListBean> song_list;

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public List<SongListBean> getSong_list() {
                return song_list;
            }

            public void setSong_list(List<SongListBean> song_list) {
                this.song_list = song_list;
            }

            public static class SongListBean {
                /**
                 * content :
                 * copy_type : 1
                 * toneid : 0
                 * info :
                 * all_rate : 320,128,flac,256,192,64,24
                 * resource_type : 2
                 * relate_status : 0
                 * has_mv_mobile : 1
                 * song_id : 18401298
                 * title : 七里香
                 * ting_uid : 7994
                 * author : 周杰伦
                 * album_id : 18394691
                 * album_title : 第五届百事音乐风云榜
                 * is_first_publish : 0
                 * havehigh : 2
                 * charge : 0
                 * has_mv : 0
                 * learn : 0
                 * song_source : web
                 * piao_id : 0
                 * korean_bb_song : 0
                 * resource_type_ext : 0
                 * artist_id : 29
                 * all_artist_id : 29
                 * lrclink : http://musicdata.baidu.com/data2/lrc/65094964/%E4%B8%83%E9%87%8C%E9%A6%99.lrc
                 * data_source : 0
                 * cluster_id : 93119037
                 */

                private String content;
                private String copy_type;
                private String toneid;
                private String info;
                private String all_rate;
                private int resource_type;
                private int relate_status;
                private int has_mv_mobile;
                private String song_id;
                private String title;
                private String ting_uid;
                private String author;
                private String album_id;
                private String album_title;
                private int is_first_publish;
                private int havehigh;
                private int charge;
                private int has_mv;
                private int learn;
                private String song_source;
                private String piao_id;
                private String korean_bb_song;
                private String resource_type_ext;
                private String artist_id;
                private String all_artist_id;
                private String lrclink;
                private int data_source;
                private int cluster_id;

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public String getCopy_type() {
                    return copy_type;
                }

                public void setCopy_type(String copy_type) {
                    this.copy_type = copy_type;
                }

                public String getToneid() {
                    return toneid;
                }

                public void setToneid(String toneid) {
                    this.toneid = toneid;
                }

                public String getInfo() {
                    return info;
                }

                public void setInfo(String info) {
                    this.info = info;
                }

                public String getAll_rate() {
                    return all_rate;
                }

                public void setAll_rate(String all_rate) {
                    this.all_rate = all_rate;
                }

                public int getResource_type() {
                    return resource_type;
                }

                public void setResource_type(int resource_type) {
                    this.resource_type = resource_type;
                }

                public int getRelate_status() {
                    return relate_status;
                }

                public void setRelate_status(int relate_status) {
                    this.relate_status = relate_status;
                }

                public int getHas_mv_mobile() {
                    return has_mv_mobile;
                }

                public void setHas_mv_mobile(int has_mv_mobile) {
                    this.has_mv_mobile = has_mv_mobile;
                }

                public String getSong_id() {
                    return song_id;
                }

                public void setSong_id(String song_id) {
                    this.song_id = song_id;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getTing_uid() {
                    return ting_uid;
                }

                public void setTing_uid(String ting_uid) {
                    this.ting_uid = ting_uid;
                }

                public String getAuthor() {
                    return author;
                }

                public void setAuthor(String author) {
                    this.author = author;
                }

                public String getAlbum_id() {
                    return album_id;
                }

                public void setAlbum_id(String album_id) {
                    this.album_id = album_id;
                }

                public String getAlbum_title() {
                    return album_title;
                }

                public void setAlbum_title(String album_title) {
                    this.album_title = album_title;
                }

                public int getIs_first_publish() {
                    return is_first_publish;
                }

                public void setIs_first_publish(int is_first_publish) {
                    this.is_first_publish = is_first_publish;
                }

                public int getHavehigh() {
                    return havehigh;
                }

                public void setHavehigh(int havehigh) {
                    this.havehigh = havehigh;
                }

                public int getCharge() {
                    return charge;
                }

                public void setCharge(int charge) {
                    this.charge = charge;
                }

                public int getHas_mv() {
                    return has_mv;
                }

                public void setHas_mv(int has_mv) {
                    this.has_mv = has_mv;
                }

                public int getLearn() {
                    return learn;
                }

                public void setLearn(int learn) {
                    this.learn = learn;
                }

                public String getSong_source() {
                    return song_source;
                }

                public void setSong_source(String song_source) {
                    this.song_source = song_source;
                }

                public String getPiao_id() {
                    return piao_id;
                }

                public void setPiao_id(String piao_id) {
                    this.piao_id = piao_id;
                }

                public String getKorean_bb_song() {
                    return korean_bb_song;
                }

                public void setKorean_bb_song(String korean_bb_song) {
                    this.korean_bb_song = korean_bb_song;
                }

                public String getResource_type_ext() {
                    return resource_type_ext;
                }

                public void setResource_type_ext(String resource_type_ext) {
                    this.resource_type_ext = resource_type_ext;
                }

                public String getArtist_id() {
                    return artist_id;
                }

                public void setArtist_id(String artist_id) {
                    this.artist_id = artist_id;
                }

                public String getAll_artist_id() {
                    return all_artist_id;
                }

                public void setAll_artist_id(String all_artist_id) {
                    this.all_artist_id = all_artist_id;
                }

                public String getLrclink() {
                    return lrclink;
                }

                public void setLrclink(String lrclink) {
                    this.lrclink = lrclink;
                }

                public int getData_source() {
                    return data_source;
                }

                public void setData_source(int data_source) {
                    this.data_source = data_source;
                }

                public int getCluster_id() {
                    return cluster_id;
                }

                public void setCluster_id(int cluster_id) {
                    this.cluster_id = cluster_id;
                }
            }
        }

        public static class AlbumInfoBean {
            /**
             * total : 2
             * album_list : [{"album_id":"67909","author":"周杰伦","hot":22412,"title":"<em>七里香<\/em>","artist_id":"29","all_artist_id":"29","company":"杰威尔JVR音乐有限公司","publishtime":"2004-08-03","album_desc":"周杰伦的新专辑在8月3日正式发行，这次引用了诗人席幕蓉名诗《<em>七里香<\/em>》作为新专辑名称，周杰伦以往每一次的专辑名称都给了歌迷许多想象空间，也给了大家许多惊叹号。这次也许并不令人惊喜。但是周杰伦自有说法：\u201c...","pic_small":"http://musicdata.baidu.com/data2/pic/115430825/115430825.jpg"},{"album_id":"183906","author":"周杰伦 ","hot":10799,"title":"<em>七里香<\/em>(台湾正式版)","artist_id":"29","all_artist_id":"29","company":"杰威尔JVR音乐有限公司","publishtime":"2004-08-03","album_desc":"周杰伦的新专辑在8月3日正式发行,这次引用了诗人席幕蓉名诗《<em>七里香<\/em>》作为新专辑名称,周杰伦以往每一次的专辑名称都给了歌迷许多想象空间,也给了大家许多惊叹号。这次也许并不令人惊喜。但是周杰伦自有说法：\u201c...","pic_small":"http://c.hiphotos.baidu.com/ting/pic/item/b8389b504fc2d562b542b1f8e51190ef76c66c58.jpg"}]
             */

            private int total;
            private List<AlbumListBean> album_list;

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public List<AlbumListBean> getAlbum_list() {
                return album_list;
            }

            public void setAlbum_list(List<AlbumListBean> album_list) {
                this.album_list = album_list;
            }

            public static class AlbumListBean {
                /**
                 * album_id : 67909
                 * author : 周杰伦
                 * hot : 22412
                 * title : <em>七里香</em>
                 * artist_id : 29
                 * all_artist_id : 29
                 * company : 杰威尔JVR音乐有限公司
                 * publishtime : 2004-08-03
                 * album_desc : 周杰伦的新专辑在8月3日正式发行，这次引用了诗人席幕蓉名诗《<em>七里香</em>》作为新专辑名称，周杰伦以往每一次的专辑名称都给了歌迷许多想象空间，也给了大家许多惊叹号。这次也许并不令人惊喜。但是周杰伦自有说法：“...
                 * pic_small : http://musicdata.baidu.com/data2/pic/115430825/115430825.jpg
                 */

                private String album_id;
                private String author;
                private int hot;
                private String title;
                private String artist_id;
                private String all_artist_id;
                private String company;
                private String publishtime;
                private String album_desc;
                private String pic_small;

                public String getAlbum_id() {
                    return album_id;
                }

                public void setAlbum_id(String album_id) {
                    this.album_id = album_id;
                }

                public String getAuthor() {
                    return author;
                }

                public void setAuthor(String author) {
                    this.author = author;
                }

                public int getHot() {
                    return hot;
                }

                public void setHot(int hot) {
                    this.hot = hot;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getArtist_id() {
                    return artist_id;
                }

                public void setArtist_id(String artist_id) {
                    this.artist_id = artist_id;
                }

                public String getAll_artist_id() {
                    return all_artist_id;
                }

                public void setAll_artist_id(String all_artist_id) {
                    this.all_artist_id = all_artist_id;
                }

                public String getCompany() {
                    return company;
                }

                public void setCompany(String company) {
                    this.company = company;
                }

                public String getPublishtime() {
                    return publishtime;
                }

                public void setPublishtime(String publishtime) {
                    this.publishtime = publishtime;
                }

                public String getAlbum_desc() {
                    return album_desc;
                }

                public void setAlbum_desc(String album_desc) {
                    this.album_desc = album_desc;
                }

                public String getPic_small() {
                    return pic_small;
                }

                public void setPic_small(String pic_small) {
                    this.pic_small = pic_small;
                }
            }
        }
    }
}
