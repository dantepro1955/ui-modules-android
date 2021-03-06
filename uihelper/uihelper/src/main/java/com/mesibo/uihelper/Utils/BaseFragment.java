/* By obtaining and/or copying this work, you agree that you have read,
 * understood and will comply with the following terms and conditions.
 *
 * Copyright (c) 2020 Mesibo
 * https://mesibo.com
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the terms and condition mentioned
 * on https://mesibo.com as well as following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions, the following disclaimer and links to documentation and
 * source code repository.
 *
 * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * Neither the name of Mesibo nor the names of its contributors may be used to
 * endorse or promote products derived from this software without specific prior
 * written permission.
 *
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * Documentation
 * https://mesibo.com/documentation/
 *
 * Source Code Repository
 * https://github.com/mesibo/ui-modules-android

 */
package com.mesibo.uihelper.Utils;



import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;

// We created this class to ensure that all fragments are derived from android.support.v4.app.Fragment
public class BaseFragment extends Fragment implements ActivityListener, View.OnClickListener {
    protected FragmentListener mFragmentListener;
    protected Activity mActivity;
    protected String TABNAME = "";

    // if getActivity is called in another thread after fragment was removed say after API response,
    // getActivity may return NULL and hence we are storing the reference
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = activity;
        try {
            mFragmentListener = (FragmentListener) activity;
        } catch (ClassCastException e) {
            mFragmentListener = null;
            //throw new ClassCastException(activity.toString() + " must implement FragmentListener");
        }
    }

    /*
    //This only works from  viewpager
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        //Log.d(TAG, "Class " + this.getClass() + " visible " + isVisibleToUser);
        if(null != mFragmentListener)
            mFragmentListener.onFragmentLoaded(this, this.getClass(), isVisibleToUser);
    }

    @Override
    public void onResume() {
        super.onResume();
        if(null != mFragmentListener)
            mFragmentListener.onFragmentLoaded(this, this.getClass(), true);
    }

    */

    @Override
    public boolean onBackPressed() {
        return false;
    }

    @Override
    public void onClick(View view) {
        onClick(view.getId());
    }

    public void onClick(int id) {

    }

    public String getName() {
        return TABNAME;
    }

    @Override
    public void onActivityResultPrivate(int requestCode, int resultCode, Intent data) {

    }
}
