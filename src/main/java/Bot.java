import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Bot extends TelegramLongPollingBot {
    public static final String TOKEN = "1243360459:AAEzMCyDYD6EbbXGJ1JyjLCzeQM44t336uA";
    public static final String USERNAME = "cities_admin_bot.";

    public Bot() {
    }

    public Bot(DefaultBotOptions options) {
        super(options);
    }

    public void onUpdateReceived(Update update) {
        if(update.hasMessage()){
            processMessage(update.getMessage());
        }
    }

    private void processMessage(Message message) {
        if(isFirst(message.getText())){
            send(message, "Greeting, please type in City Name");
        } else if(isValid(message.getText())){
            send(message, "hi, you send a message " + message.getText());
        }
    }

    private void send(Message message, String text) {

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(text);
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId());
        sendMessage.setReplyToMessageId(message.getMessageId());

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            Logger.getLogger(Bot.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private boolean isValid(String text) {
        return text.trim().length()>0;
    }

    private boolean isFirst(String text){
        return text.equals("/start") || text.equals("/restart");
    }


    public String getBotUsername() {
        return USERNAME;
    }

    public String getBotToken() {
        return TOKEN;
    }
}
