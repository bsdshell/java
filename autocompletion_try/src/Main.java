/**
 * Copyright (c) 2014, ControlsFX
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 *     * Neither the name of ControlsFX, any associated website, nor the
 * names of its contributors may be used to endorse or promote products
 * derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL CONTROLSFX BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
//package org.controlsfx.samples.textfields;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import org.controlsfx.ControlsFXSample;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;
import org.controlsfx.samples.Utils;

import java.util.*;

public class Main extends ControlsFXSample {

    private AutoCompletionBinding<String> autoCompletionBinding;
    private String[] _possibleSuggestions = {"Hey", "Hello", "Hello World", "Apple", "Cool", "Costa", "Cola", "Coca Cola"};
    private Set<String> possibleSuggestions = new HashSet<>(Arrays.asList(_possibleSuggestions));

    private TextField learningTextField;

    @Override public String getSampleName() {
        return "AutoComplete";
    }

    @Override public String getJavaDocURL() {
        return Utils.JAVADOC_BASE + "org/controlsfx/control/textfield/TextFields.html";
    }

    @Override public String getSampleDescription() {
        return "AutoComplete helps a user with suggestions to type faster, "
                + "but does not limit the user from entering alternative text."
                + "\n\n"
                + "The textfields have been primed with the following words:\n"
                + "\"Hey\", \"Hello\", \"Hello World\", \"Apple\", \"Cool\", "
                + "\"Costa\", \"Cola\", \"Coca Cola\""
                + "\n\n"
                + "The 'Learning TextField' will add whatever words are typed "
                + "to the auto-complete popup, as long as you press Enter once "
                + "you've finished typing the word.";
    }

    @Override public Node getPanel(final Stage stage) {

        BorderPane root = new BorderPane();

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(30, 30, 0, 30));

        //
        // TextField with static auto-complete functionality
        //

        List<String> list = Arrays.asList("dog", "cat", "Autocompletion", "autocompletion");

        TextField textField = new TextField();
/*
        TextFields.bindAutoCompletion(
                textField,
                "Hey", "Hello", "Hello World", "Apple", "Cool", "Costa", "Cola", "Coca Cola", "Dog", "DogCat");
*/

        TextFields.bindAutoCompletion(textField, list);


        grid.add(new Label("Auto-complete Text"), 0, 0);
        grid.add(textField, 1, 0);
        GridPane.setHgrow(textField, Priority.ALWAYS);


        //
        // TextField with learning auto-complete functionality
        // Learn the word when user presses ENTER
        //
        learningTextField = new TextField();
//        autoCompletionBinding = TextFields.bindAutoCompletion(learningTextField, possibleSuggestions);
//        learningTextField.setOnKeyPressed(new EventHandler<KeyEvent>() {
//            @Override
//            public void handle(KeyEvent ke) {
//                switch (ke.getCode()) {
//                case ENTER:
//                    autoCompletionLearnWord(learningTextField.getText().trim());
//                    break;
//                default:
//                    break;
//                }
//            }
//        });
//
//        grid.add(new Label("Learning TextField"), 0, 1);
//        grid.add(learningTextField, 1, 1);
//        GridPane.setHgrow(learningTextField, Priority.ALWAYS);
//
        root.setTop(grid);
        return root;
    }

    private void autoCompletionLearnWord(String newWord){
        possibleSuggestions.add(newWord);

        // we dispose the old binding and recreate a new binding
        if (autoCompletionBinding != null) {
            autoCompletionBinding.dispose();
        }
        autoCompletionBinding = TextFields.bindAutoCompletion(learningTextField, possibleSuggestions);
    }

    @Override public Node getControlPanel() {
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(30, 30, 0, 30));

        // TODO Add customization example controls


        return grid;
    }


    public static void main(String[] args) {
        launch(args);
    }

}