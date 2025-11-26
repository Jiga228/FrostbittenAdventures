package com.github.Jiga228.GameEngine.Controller;

public class CharacterController implements IController {
    private Character character;
    private final Object mCharacter = new Object();

    public CharacterController(Character character) {
        this.character = character;
    }

    public Character getCharacter() {
        synchronized (mCharacter) {
            return character;
        }
    }

    public void setCharacter(Character character) {
        synchronized (mCharacter)
        {
            OnSetCharacter(character);
            this.character = character;
        }
    }

    protected void OnSetCharacter(Character newCh)
    {}
}
