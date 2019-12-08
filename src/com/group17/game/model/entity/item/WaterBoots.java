/**
 * Class defining the water boots items
 * @author
 */
package com.group17.game.model.entity.item;

import com.group17.game.controller.SceneController;

public class WaterBoots extends Item {
    public WaterBoots() {
        super(SceneController.getLanguageBundle().getString("item_waterBoots"), "item_waterboots");
    }

    @Override
    public String toString() {
        return SceneController.getLanguageBundle().getString("item_waterBoots");
    }
}
