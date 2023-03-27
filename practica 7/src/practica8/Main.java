package practica8;

import practica8.mediator.ChatRoom;
import practica8.mediator.ChatUser;
import practica8.mediator.IChatRoom;
import practica8.mediator.User;
import practica8.memento.Article;
import practica8.memento.ArticleMemento;

public class Main {
    public static void main(String[] args) {
        IChatRoom chatroom = new ChatRoom();

        User user1 = new ChatUser(chatroom,"1", "Alex");
        User user2 = new ChatUser(chatroom,"2", "Brian");
        User user3 = new ChatUser(chatroom,"3", "Charles");
        User user4 = new ChatUser(chatroom,"4", "David");

        chatroom.addUser(user1);
        chatroom.addUser(user2);
        chatroom.addUser(user3);
        chatroom.addUser(user4);


        user1.send("Hello brian", "2");
        user2.send("Hey buddy", "1");

        System.out.println();

        Article article = new Article(1 , "my article");
        article.setContent("skjfhskjfhsf");
        System.out.println(article);

        ArticleMemento memento = article.creatememento();

        article.setContent("756348756345");
        System.out.println(article);

        article.restore(memento);
        System.out.println(article);
    }
}
