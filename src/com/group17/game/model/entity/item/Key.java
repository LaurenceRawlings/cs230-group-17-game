/**
 * This is the class for the key item. This class allows distinction between
 * all the different coloured keys.
 * @author
 */
package com.group17.game.model.entity.item;

import com.group17.game.controller.SceneController;

import java.util.Objects;

public class Key extends Item {
    public enum KeyType{
        red(SceneController.getLanguageBundle().getString("colour_red")),
        green(SceneController.getLanguageBundle().getString("colour_green")),
        blue(SceneController.getLanguageBundle().getString("colour_blue"));

        private final String label;

        KeyType(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }

    private KeyType keyType;
    
   /**
    * This key method sets the sprite names according to their colour
    * @param keyType
    */
    public Key(KeyType keyType) {
        super(keyType.getLabel() + " " + SceneController.getLanguageBundle().getString("item_key"), "missing_item");
        this.keyType = keyType;
        switch (keyType) {
            case red:
                setSpriteName("key_red");
                break;
            case green:
                setSpriteName("key_green");
                break;
            case blue:
                setSpriteName("key_blue");
                break;
            default:
                break;
        }
    }
    
   /**
    * Returns the type of key
    * @return keyType
    */

    public KeyType getKeyType() {
        return keyType;
    }

    /**
     * Two instances of a key object are compared
     * @param o
     * @return true if the two instances have the same key type
     */
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Key key = (Key) o;
        return keyType == key.keyType;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), keyType);
    }
}
