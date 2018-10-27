package com.fmx.tool.hdfsfilemanager.service.core;

import com.fmx.tool.hdfsfilemanager.service.core.impl.HDFSCore;

/**
 */
public class HDFSCoreFactory {

    public static HDFSCore GetHDFSCore(TYPE type) throws Exception {
        switch (type) {
            case api:
                return new HAPICore();
            case curl:
                return new CurlCore();
            case httpclient:
                return new HClientCore();
            default:
                return null;
        }
    }

    public enum TYPE {
        api, httpclient, curl
    }
}
