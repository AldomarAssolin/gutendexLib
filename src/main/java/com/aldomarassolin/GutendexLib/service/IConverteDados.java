package com.aldomarassolin.GutendexLib.service;

public interface IConverteDados {
    <T> T  obterDados(String json, Class<T> classe);
}
