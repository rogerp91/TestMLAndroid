package com.github.rogerp91.ml.item;

import com.github.rogerp91.ml.data.source.SearchDataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class ItemPresenterTest {

    @Mock
    ItemContract.View mView;

    @Mock
    SearchDataSource mRepositor;

    private ItemPresenter itemPresenter;

    @Before
    public void setUp() throws Exception {
        itemPresenter = new ItemPresenter(mView, mRepositor);
    }

    @Test
    public void queryTextSubmit_verifyQueryIsNull_showMessage() {
        itemPresenter.queryTextSubmit("A");
        Mockito.verify(mView).showMessage(Mockito.anyString());
    }
}