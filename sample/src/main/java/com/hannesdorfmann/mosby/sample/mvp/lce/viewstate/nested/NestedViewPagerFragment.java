/*
 *  Copyright 2015. Hannes Dorfmann.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.hannesdorfmann.mosby.sample.mvp.lce.viewstate.nested;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import butterknife.Bind;
import com.hannesdorfmann.mosby.MosbyFragment;
import com.hannesdorfmann.mosby.sample.R;
import com.hannesdorfmann.mosby.sample.mvp.lce.viewstate.NotRetainingCountriesFragment;

/**
 * @author Hannes Dorfmann
 */
public class NestedViewPagerFragment extends MosbyFragment {

  @Bind(R.id.viewPager) ViewPager viewPager;
  @Bind(R.id.tabs) TabLayout tabLayout;

  @Override protected int getLayoutRes() {
    return R.layout.fragment_nested_viewpager;
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    viewPager.setAdapter(new NestedPagerAdapter(getChildFragmentManager()));
    tabLayout.setupWithViewPager(viewPager);
  }

  private class NestedPagerAdapter extends FragmentPagerAdapter {

    public NestedPagerAdapter(FragmentManager fm) {
      super(fm);
    }

    @Override public Fragment getItem(int position) {
      return new NotRetainingCountriesFragment();
    }

    @Override public int getCount() {
      return 5;
    }

    @Override public CharSequence getPageTitle(int position) {
      return "Fragment " + position;
    }
  }
}