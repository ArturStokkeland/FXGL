/*
 * The MIT License (MIT)
 *
 * FXGL - JavaFX Game Library
 *
 * Copyright (c) 2015 AlmasB (almaslvl@gmail.com)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.almasb.fxgl.asset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javafx.scene.media.AudioClip;

import com.almasb.fxgl.FXGLLogger;

/**
 * Stores cached data
 */
public final class Assets {

    private static final Logger log = FXGLLogger.getLogger("Assets");

    private Map<String, Texture> cachedTextures = new HashMap<>();
    private Map<String, AudioClip> cachedAudio = new HashMap<>();
    private Map<String, Music> cachedMusic = new HashMap<>();
    private Map<String, List<String> > cachedText = new HashMap<>();
    private Map<String, Object> cachedData = new HashMap<>();

    /*package-private*/ Assets() {

    }

    /*package-private*/ void putTexture(String key, Texture texture) {
        cachedTextures.put(key, texture);
    }

    /*package-private*/ void putAudio(String key, AudioClip audio) {
        cachedAudio.put(key, audio);
    }

    /*package-private*/ void putMusic(String key, Music music) {
        cachedMusic.put(key, music);
    }

    /*package-private*/ void putText(String key, List<String> text) {
        cachedText.put(key, text);
    }

    /*package-private*/ void putData(String key, Object data) {
        cachedData.put(key, data);
    }

    /**
     * Returns a new copy of a cached texture so
     * it is safe to use multiple times
     *
     * @param key
     * @return
     */
    public Texture getTexture(String key) {
        return cachedTextures.get(key).copy();
    }

    public AudioClip getAudio(String key) {
        return cachedAudio.get(key);
    }

    public Music getMusic(String key) {
        return cachedMusic.get(key);
    }

    /**
     * Returns new list contains original text
     *
     * @param key
     * @return
     */
    public List<String> getText(String key) {
        return new ArrayList<>(cachedText.get(key));
    }

    @SuppressWarnings("unchecked")
    public <T> T getData(String key) {
        return (T) cachedData.get(key);
    }

    /**
     * A convenience method to print all cached assets
     */
    public void logCached() {
        log.info("Logging cached assets");
        cachedTextures.forEach((name, texture) -> log.info("Texture:" + name));
        cachedAudio.forEach((name, audio) -> log.info("Audio:" + name));
        cachedMusic.forEach((name, music) -> log.info("Music:" + name));
        cachedText.forEach((name, text) -> log.info("Text:" + name));
        cachedData.forEach((name, data) -> log.info("Data:" + name));
    }

    /**
     *
     * @return  size of all cached assets
     */
    public int size() {
        return cachedTextures.size() + cachedAudio.size() + cachedMusic.size();
    }
}