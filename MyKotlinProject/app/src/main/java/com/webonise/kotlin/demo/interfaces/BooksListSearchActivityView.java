package com.webonise.kotlin.demo.interfaces;

import com.webonise.kotlin.demo.models.BooksListModel;

import org.jetbrains.annotations.Nullable;

import java.util.List;


public interface BooksListSearchActivityView {

    void updateUi(@Nullable List<BooksListModel> booksList);

    void updateError();
}
