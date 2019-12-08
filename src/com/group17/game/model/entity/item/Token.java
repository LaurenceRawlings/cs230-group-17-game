/**
 * Class defining the Token item adding a sprite to each object
 * @author
 */
package com.group17.game.model.entity.item;

import com.group17.game.controller.SceneController;

public class Token extends Item {
    public Token() {
        super(SceneController.getLanguageBundle().getString("item_token"), "token");
    }

    @Override
    public String toString() {
        return SceneController.getLanguageBundle().getString("item_token");
    }
}
