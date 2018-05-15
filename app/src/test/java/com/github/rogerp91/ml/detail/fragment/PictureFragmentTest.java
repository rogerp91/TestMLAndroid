package com.github.rogerp91.ml.detail.fragment;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class PictureFragmentTest {

    PictureFragment pictureFragmentTest;

    @Before
    public void setUp() throws Exception {
        pictureFragmentTest = new PictureFragment();
    }

    @Test(expected = IllegalArgumentException.class)
    public void bind() {
        pictureFragmentTest.bind(null);
    }
}