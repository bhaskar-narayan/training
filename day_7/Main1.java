/*
 Question 1: OOPs

 Create a whats app as following 

 Users having contacts and can chat with any contact

 Messaging in text audio and video 

 Users can see status of all the contacts

 User can post status

 Status can be text and image

*/


class Status {
    String type;
    String value;
    void setType(String type) {
        this.type = type;
    }
    void setValue(String value) {
        this.value = value;
    }
}
class Image extends Status {}
class Text extends Status {}
class Video extends Status {}
class Chat {
    String type;
    String value;
    long number;
    void setType(String type) {
        this.type = type;
    }
    void setValue(String value, long number) {
        this.value = value;
        this.number = number;
    }
    String isNULL() {
        return type;
    }
    void getValue() {
        System.out.println(type + ": " + value + " ---by: " + number);
    }
}
class TextChat extends Chat {}
class AudioChat extends Chat {}
class VideoChat extends Chat {}
class ImageChat extends Chat {}
class Contact {
    String name;
    long number;
    Status image = new Image();
    Status text = new Text();
    Status video = new Video();

    Chat textChat = new TextChat();
    Chat audioChat = new AudioChat();
    Chat imageChat = new ImageChat();
    Chat videoChat = new VideoChat();

    void createUser(String name, long number) {             // user registration
        this.name = name;
        this.number = number;
    }
    void whoAmI() {                                         // about me
        System.out.println("I am: " + name + "\n" + "Mobile: " + number);
    }
    void post(String postType, String postValue) {          // posting a status
        if (postType.trim().equalsIgnoreCase("image")) {
            image.setType("image");
            image.setValue(postValue);
        } else if (postType.trim().equalsIgnoreCase("video")) {
            video.setType("image");
            video.setValue(postValue);
        } else if (postType.trim().equalsIgnoreCase("text")) {
            text.setType("text");
            text.setValue(postValue);
        } else {
            System.out.println("Invalid status-type");
        }
    }
    void viewMyPost() {                                     // show personal status
        
        System.out.println(image.value);
        System.out.println(video.value);
        System.out.println(text.value);
    }
    void showAllStatus(Contact contact[]) {                 // show all status
        for (int i = 0; i < contact.length; ++i) {
            contact[i].viewMyPost();
        }
    }
    void sendText(Contact receiver, String value) {         // sending chat
        receiver.textChat.setType("text");
        receiver.textChat.setValue(value, number);
    }
    void sendAudio(Contact receiver, String value) {
        receiver.audioChat.setType("audio");
        receiver.audioChat.setValue(value, number);
    }
    void sendVideo(Contact receiver, String value) {
        receiver.videoChat.setType("video");
        receiver.videoChat.setValue(value, number);
    }
    void sendImage(Contact receiver, String value) {
        receiver.imageChat.setType("image");
        receiver.imageChat.setValue(value, number);
    }
    void showInbox() {                                      // view inbox
        if (textChat.isNULL() != null)
            textChat.getValue();
        if (audioChat.isNULL() != null)
            audioChat.getValue();
        if (videoChat.isNULL() != null)
            videoChat.getValue();
        if (imageChat.isNULL() != null)
            imageChat.getValue();
    }
}

public class Main1 {
    public static void main(String[] args) {
        Contact contact = new Contact();
        contact.createUser("Bhaskar Narayan", 7596949008L);
//        contact.whoAmI();
//        contact.post("image", "image");
        Contact contact1 = new Contact();
        contact1.createUser("Bhaskar 2", 7001618081L);
//        contact1.whoAmI();
//        contact1.post("image", "sample image");
//        Contact contact2 = new Contact();
//        contact2.createUser("Bhaskar", 7596949008L);
//        contact2.whoAmI();
//        contact2.post("image", "This is a sample image");
//        contact.showAllStatus(new Contact[]{contact1, contact2});
        contact.sendText(contact1, "Hello This is Bhaskar Narayan");
        contact1.showInbox();
    }
}