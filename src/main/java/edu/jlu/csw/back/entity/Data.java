package edu.jlu.csw.back.entity;

import java.io.File;
import java.util.ArrayList;

public record Data(ArrayList<File>oldFiles,
                   File newDirectory,
                   String newFormat,
                   Boolean isEncryption,
                   String password) {
}
