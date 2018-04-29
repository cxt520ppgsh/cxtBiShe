package com.example.ryzen1400.abd.model.base;

import com.example.ryzen1400.abd.model.bean.MarketItem;
import com.example.ryzen1400.abd.model.bean.MessageItem;
import com.example.ryzen1400.abd.model.bean.PriceItem;
import com.example.ryzen1400.abd.model.bean.UpItem;

public interface BaseLoadFinishListener {
    void  loadSucced(Object... parms);
    void  loadFaild(Object... parms);
}
