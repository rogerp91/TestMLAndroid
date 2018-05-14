package com.github.rogerp91.ml.detail.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.rogerp91.ml.R;
import com.github.rogerp91.ml.common.BaseFragment;
import com.github.rogerp91.ml.data.model.Attribute;
import com.github.rogerp91.ml.util.Const;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class CharacteristicsFragment extends BaseFragment implements BindFragment {

    @BindView(R.id.progress)
    ProgressBar progress;
    @BindView(R.id.title)
    AppCompatTextView title;
    @BindView(R.id.brand)
    TextView brand;
    @BindView(R.id.model)
    TextView model;
    @BindView(R.id.ll_section_1)
    LinearLayout llSection1;
    @BindView(R.id.item)
    TextView item;
    @BindView(R.id.unknown)
    TextView unknown;
    @BindView(R.id.unknown_value)
    TextView unknownValue;
    @BindView(R.id.ll_section_2)
    LinearLayout llSection2;
    @BindView(R.id.ll_characteristics)
    LinearLayout llCharacteristics;

    String mBrand;
    String mModel;
    String mItem;

    List<Attribute> attr;

    @Override
    public int getLayoutView() {
        return R.layout.fragment_characteristics;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void onViewReady(@Nullable Bundle savedInstanceState, @Nullable View view) {

    }

    @Override
    public void bind(Object... t) {
        progress.setVisibility(View.GONE);
        llCharacteristics.setVisibility(View.VISIBLE);
        attr = getListOfAttributeFromObject(t[0]);
        bindAttribute(attr);
    }

    private void bindAttribute(List<Attribute> attr) {
        if (attr.size() != 0) {
            selectAttr(attr);
        }
    }

    private void selectAttr(List<Attribute> attr) {
        Log.w("ATTR", String.valueOf(attr.size()));

        for (int i = 0; i < attr.size(); i++) {
            Attribute attribute = attr.get(i);
            if (attribute.getId().equals(Const.MODEL)) {
                mModel = attribute.getValueName();
                attr.remove(i);
            }
            if (attribute.getId().equals(Const.BRAND)) {
                mBrand = attribute.getValueName();
                attr.remove(attribute);
            }
            if (attribute.getId().equals(Const.ITEM_CONDITION)) {
                mItem = attribute.getValueName();
                attr.remove(attribute);
            }
        }

        getAttrRandom(attr);

    }

    private void getAttrRandom(List<Attribute> attr) {
        Random rand = new Random();
        Attribute attribute = attr.get(rand.nextInt(attr.size()));

        model.setText(mModel);
        brand.setText(mBrand);
        item.setText(mItem);
        unknown.setText(attribute.getName());
        unknownValue.setText(attribute.getValueName());
    }

    private List<Attribute> getListOfAttributeFromObject(final Object objectList) {
        List<Attribute> attributeList = new ArrayList<>();
        if (objectList instanceof List<?>) {
            for (Object object : (List<?>) objectList) {
                if (object instanceof Attribute) {
                    attributeList.add((Attribute) object);
                }
            }
        }
        return attributeList;
    }

}