package com.ty.android.mymvpdemo.model.entity;

import java.util.List;

/**
 * Created by Android on 2017/6/19.
 */

public class ZhiHuLatest {

    /**
     * date : 20170619
     * stories : [{"images":["https://pic2.zhimg.com/v2-f21d8a5033f041cf0fbb8f19afbc5455.jpg"],"type":0,"id":9482756,"ga_prefix":"061919","title":"扭一扭、再扭一扭\u2026\u2026小小的扭蛋为什么让人上瘾？"},{"images":["https://pic4.zhimg.com/v2-f3897a37df04d22706b53d6d9d55ead7.jpg"],"type":0,"id":9483421,"ga_prefix":"061918","title":"虚伪的爱情、虚伪的社会、还有虚伪的美国梦"},{"images":["https://pic2.zhimg.com/v2-1e081be9e1ffcd424303c7c5d0879a51.jpg"],"type":0,"id":9471474,"ga_prefix":"061917","title":"以唐代的技术水平，老奶奶把铁杵磨成针可能吗？"},{"images":["https://pic3.zhimg.com/v2-dfb7def8057f4974dee3fa8ca2a280e2.jpg"],"type":0,"id":9480946,"ga_prefix":"061916","title":"小说和电影里经常出现的「朗姆酒」，究竟是什么味儿？"},{"images":["https://pic4.zhimg.com/v2-9be3a4d7668a3b0fd67483ac14fb3027.jpg"],"type":0,"id":9483023,"ga_prefix":"061915","title":"绝对不会找我爸这样的男人，因为不想变成第二个我妈"},{"images":["https://pic4.zhimg.com/v2-3fd53090df76771d20b02c79d0c4d203.jpg"],"type":0,"id":9482130,"ga_prefix":"061914","title":"聚光灯好了麦克风也好了，这位细菌，请说出你的故事"},{"images":["https://pic4.zhimg.com/v2-a8ecc5f9e583bbbcf12cbcbd8f260fd7.jpg"],"type":0,"id":9482106,"ga_prefix":"061913","title":"137 亿美元买了家高端有机食品超市，亚马逊这是要干嘛？"},{"images":["https://pic2.zhimg.com/v2-7b595ce0d4de3552e9761f4051b3b9ed.jpg"],"type":0,"id":9481812,"ga_prefix":"061912","title":"大误 · 偏偏不爱你"},{"images":["https://pic1.zhimg.com/v2-96e50aabc5a9e0b8a876971b78d2ba64.jpg"],"type":0,"id":9481787,"ga_prefix":"061911","title":"为什么很多人坚信「富贵险中求」？"},{"images":["https://pic1.zhimg.com/v2-8149914976e539c9a5e621b64bbc6bf8.jpg"],"type":0,"id":9432905,"ga_prefix":"061910","title":"刚创业的小公司，怎样记好账？"},{"images":["https://pic3.zhimg.com/v2-3fe79f7ca5294221962acf82ec17ace2.jpg"],"type":0,"id":9480955,"ga_prefix":"061909","title":"昨天：明天我绝对不迟到\r\n今天：对不起老板，今天我\u2026\u2026"},{"images":["https://pic1.zhimg.com/v2-1b4676136093254a693a52b0fe468074.jpg"],"type":0,"id":9482404,"ga_prefix":"061908","title":"说海豚不用嘴呼吸是没错，只是没想到「还有这种操作？」"},{"images":["https://pic1.zhimg.com/v2-2e3bcb3e0ff89bb7677c704af1899ca8.jpg"],"type":0,"id":9481378,"ga_prefix":"061907","title":"有车有房月入四万五，才算刚刚摸到「中产阶级」的边？"},{"images":["https://pic3.zhimg.com/v2-0d6dfb4ab75812eeb0acbfe172f27be6.jpg"],"type":0,"id":9482128,"ga_prefix":"061907","title":"构思了一个惊天动地的故事，却不知道怎么写下它"},{"images":["https://pic3.zhimg.com/v2-f10d7a54cf69b6405fa040a83585c966.jpg"],"type":0,"id":9482312,"ga_prefix":"061907","title":"只要保持微笑，生活就\u2026\u2026对不起啊，生活不会因此变好"},{"images":["https://pic1.zhimg.com/v2-e69efdbd92357a5a9e17fb1dd53663c4.jpg"],"type":0,"id":9482317,"ga_prefix":"061906","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic4.zhimg.com/v2-a23288edafb617feab834d0cfa09f26b.jpg","type":0,"id":9482106,"ga_prefix":"061913","title":"137 亿美元买了家高端有机食品超市，亚马逊这是要干嘛？"},{"image":"https://pic1.zhimg.com/v2-4b1f17f3457c9051ac93203318423954.jpg","type":0,"id":9481378,"ga_prefix":"061907","title":"有车有房月入四万五，才算刚刚摸到「中产阶级」的边？"},{"image":"https://pic3.zhimg.com/v2-aeff2703e8ead0c0b2e8ab679315053a.jpg","type":0,"id":9482312,"ga_prefix":"061907","title":"只要保持微笑，生活就\u2026\u2026对不起啊，生活不会因此变好"},{"image":"https://pic4.zhimg.com/v2-7f4fbbbc9dc15355cf8f3e7c35d165d3.jpg","type":0,"id":9481623,"ga_prefix":"061816","title":"宣布结婚成了 AKB 总选举的最大新闻，偶像「恋爱禁止」有多重要？"},{"image":"https://pic3.zhimg.com/v2-fd3c20bd01d40f5f574ca62af242eee6.jpg","type":0,"id":8837604,"ga_prefix":"061807","title":"北京有哪些人不太多但有意思的景点？"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * images : ["https://pic2.zhimg.com/v2-f21d8a5033f041cf0fbb8f19afbc5455.jpg"]
         * type : 0
         * id : 9482756
         * ga_prefix : 061919
         * title : 扭一扭、再扭一扭……小小的扭蛋为什么让人上瘾？
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image : https://pic4.zhimg.com/v2-a23288edafb617feab834d0cfa09f26b.jpg
         * type : 0
         * id : 9482106
         * ga_prefix : 061913
         * title : 137 亿美元买了家高端有机食品超市，亚马逊这是要干嘛？
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
