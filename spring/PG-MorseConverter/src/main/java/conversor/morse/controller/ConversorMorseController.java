package conversor.morse.controller;

import conversor.morse.utils.Morse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/convert")
public class ConversorMorseController {


    @GetMapping("/morse/{morseSentence}")
    public String obtenerFraseEnMorse(@PathVariable String morseSentence){
        return Morse.morseToSentence(morseSentence);
    }

    @GetMapping("/word/{sentenceToConvertToMorse}")
    public String obtenerFraseAConvertirAMorse(@PathVariable String sentenceToConvertToMorse){
        return Morse.sentenceToMorse(sentenceToConvertToMorse);
    }

}
