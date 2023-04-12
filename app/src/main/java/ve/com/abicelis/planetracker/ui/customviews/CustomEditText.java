package ve.com.abicelis.planetracker.ui.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import ve.com.abicelis.planetracker.R;

/**
 * Created by abicelis on 20/9/2017.
 */

public class CustomEditText extends LinearLayout {


    @BindView(R.id.custom_edittext_icon)
    ImageView mIcon;

    @BindView(R.id.custom_edittext_text)
    EditText mEditText;

    public CustomEditText(Context context) {
        super(context);
        init(context, null);
    }
    public CustomEditText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }
    public CustomEditText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, @Nullable AttributeSet attrs) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.custom_edittext, this);

        ButterKnife.bind(this);

        //Get/apply custom xml configs
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.custom_edit_text);
        int hintColor = a.getResourceId(R.styleable.custom_edit_text_hintcolor, -1);
        int textColor = a.getResourceId(R.styleable.custom_edit_text_textcolor, -1);
        int iconId = a.getResourceId(R.styleable.custom_edit_text_icon, -1);
        int textId = a.getResourceId(R.styleable.custom_edit_text_text, -1);
        int hintId = a.getResourceId(R.styleable.custom_edit_text_hint, -1);
        int maxLines = a.getInt(R.styleable.custom_edit_text_maxlines, -1);


        setHintColor(hintColor);
        setTextColor(textColor);
        setIcon(iconId);
        setText(textId);
        setHint(hintId);
        setMaxLines(maxLines);
        a.recycle();

        //Set attributes of this (LinearLayout)
        this.setOrientation(HORIZONTAL);
        this.setGravity(Gravity.CENTER_VERTICAL);
        this.setBackgroundResource(R.drawable.round_edges_background);
    }

    public EditText getInternalEditText(){
        return mEditText;
    }

    public void setHintColor(@ColorRes int colorRes) {
        if (colorRes != -1) {
            int color = ContextCompat.getColor(getContext(), colorRes);
            mEditText.setHintTextColor(color);
        }
    }

    public void setTextColor(int colorRes) {
        if (colorRes != -1) {
            int color = ContextCompat.getColor(getContext(), colorRes);
            mEditText.setTextColor(color);
        }
    }


    public void setIcon(@DrawableRes int iconRes) {
        if (iconRes != -1) {
            mIcon.setVisibility(View.VISIBLE);
            mIcon.setImageResource(iconRes);
        } else {
            mIcon.setVisibility(View.GONE);
        }
    }

    public void setMaxLength(int length) {
        mEditText.setFilters( new InputFilter[] { new InputFilter.LengthFilter(length) } );
    }

    public void setMaxLines(int maxLines) {
        if(maxLines != -1) {
            mEditText.setMaxLines(maxLines);
            if(maxLines == 1)
                mEditText.setSingleLine();
        }
    }

    public void setInnerEditTextNotClickable() {
        mEditText.setClickable(false);
        mEditText.setFocusable(false);
        mEditText.setFocusableInTouchMode(false);
        mEditText.setMovementMethod(null);
        mEditText.setKeyListener(null);
    }

    public void setText(String text) {
        mEditText.setText(text);
    }
    public void setText(@StringRes int textId) {
        if (textId != -1)
            mEditText.setText(textId);
    }
    public String getText() {
        return mEditText.getText().toString();
    }


    public void setHint(String hint) {
        mEditText.setHint(hint);
    }
    public void setHint(@StringRes int hintId) {
        if (hintId != -1)
            mEditText.setHint(hintId);
    }

    public void addTextChangedListener(TextWatcher tw) {
        mEditText.addTextChangedListener(tw);
    }


    public void setFilters(InputFilter[] filters) {
        mEditText.setFilters(filters);
    }

    public void setDim(boolean dim) {
        if(dim) {
            setBackgroundResource(R.drawable.round_edges_background_dim);
            mEditText.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.custom_edit_text_dim_background));

            mIcon.setColorFilter(ContextCompat.getColor(getContext(), R.color.custom_edit_text_dim_foreground), android.graphics.PorterDuff.Mode.MULTIPLY);
            mEditText.setTextColor(ContextCompat.getColor(getContext(), R.color.custom_edit_text_dim_foreground));
            mEditText.setHintTextColor(ContextCompat.getColor(getContext(), R.color.custom_edit_text_dim_foreground));
        } else {
            setBackgroundResource(R.drawable.round_edges_background);
            mEditText.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.custom_edit_text_background));

            mIcon.setColorFilter(ContextCompat.getColor(getContext(), R.color.custom_edit_text_icon), android.graphics.PorterDuff.Mode.MULTIPLY);
            mEditText.setTextColor(ContextCompat.getColor(getContext(), R.color.custom_edit_text_text));
            mEditText.setHintTextColor(ContextCompat.getColor(getContext(), R.color.custom_edit_text_hint));
        }
    }
}
