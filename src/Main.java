import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class Main implements NativeKeyListener {
    String word = "";

    public static void main(String[] args)
    {
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            System.out.println("dont work");
        }



        GlobalScreen.getInstance().addNativeKeyListener(new Main());
        //langConvert toCovert = new langConvert(args[0]);
        //convertWord(toCovert);

    }

    private static void convertWord(langConvert toCovert){
        String r = toCovert.convert();
        System.out.println(r);
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {

    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
        // ENTER = reset word
        if (NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode()).equals("Enter")) {
            word = "";
        // backspace = delete last char
        } else if (NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode()).equals("Backspace")) {
            if (word.length() > 1) {
                word = word.substring(0, word.length() - 1);
            }else{
                word="";
            }
        } else {
                word = word + NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode());
        }
        //ACTIVATE WORD CONVERTER
        if (word.length()>8 &&word.charAt(word.length()-1)=='F' && word.charAt(word.length()-2) =='t'){

            word = word.substring(0,word.length()-8);
        }

        System.out.println(word);

        }
    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {

    }
}
