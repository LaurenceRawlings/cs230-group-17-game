/**
 * Class defining the fire boots item
 * @author
 */
package com.group17.game.model.entity.item;

import com.group17.game.controller.SceneController;

public class FireBoots extends Item{
    public FireBoots() {
        super(SceneController.getLanguageBundle().getString("item_fireBoots"), "item_fireboots");
    }

    @Override
    public String toString() {
        return SceneController.getLanguageBundle().getString("item_fireBoots");
    }
}
