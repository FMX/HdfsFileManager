package com.fmx.tool.hdfsfilemanager.service.core;

import com.fmx.tool.hdfsfilemanager.service.core.impl.HDFSCore;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.permission.FsAction;

import java.io.InputStream;
import java.io.OutputStream;

/**
 */
public class HClientCore implements HDFSCore {
    @Override
    public boolean exist(String path) throws Exception {
        return false;
    }

    @Override
    public boolean isDirectory(String path) throws Exception {
        return false;
    }

    @Override
    public void mkdirDirectory(String path) throws Exception {

    }

    @Override
    public void delete(String path) throws Exception {

    }

    @Override
    public void deleteRecusy(String path) throws Exception {

    }

    @Override
    public void createFile(String path) throws Exception {

    }

    @Override
    public void remove(String src, String dest) throws Exception {

    }

    @Override
    public void rename(String src, String dest) throws Exception {

    }

    @Override
    public void write(String path, InputStream reader) throws Exception {

    }

    @Override
    public void read(String hdfsFile, String otherFile) throws Exception {

    }

    @Override
    public void read(String hdfsFile, OutputStream writer) throws Exception {

    }

    @Override
    public void changePermession(String path, FsAction user, FsAction group, FsAction other) throws Exception {

    }

    @Override
    public FileStatus[] list(String path) throws Exception {
        return new FileStatus[0];
    }

    @Override
    public FileStatus[] listDirectories(String path) throws Exception {
        return new FileStatus[0];
    }
}
