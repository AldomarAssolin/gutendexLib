package com.aldomarassolin.GutendexLib.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;
import java.util.Map;

@Entity
@Table(name = "TB_BOOK")
public class Book{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", columnDefinition = "TEXT")
    private String title;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> subjects;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<Person> authors;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<Person> translators;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> bookshelves;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> languages;

    private Boolean copyright;

    @JsonProperty("media_type")
    private String mediaType;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "book_formats", joinColumns = @JoinColumn(name = "book_id"))
    @MapKeyColumn(name = "mime_type")
    @Column(name = "url", columnDefinition = "TEXT")
    private Map<String, String> formats;

    @JsonProperty("download_count")
    private int downloadCount;

    public Book() {
        // Construtor sem argumentos necessário para desserialização JSON
    }

    public Book(DadosBooks dados) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public List<Person> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Person> authors) {
        this.authors = authors;
    }

    public List<Person> getTranslators() {
        return translators;
    }

    public void setTranslators(List<Person> translators) {
        this.translators = translators;
    }

    public List<String> getBookshelves() {
        return bookshelves;
    }

    public void setBookshelves(List<String> bookshelves) {
        this.bookshelves = bookshelves;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public Boolean getCopyright() {
        return copyright;
    }

    public void setCopyright(Boolean copyright) {
        this.copyright = copyright;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public Map<String, String> getFormats() {
        return formats;
    }

    public void setFormats(Map<String, String> formats) {
        this.formats = formats;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }

    @Override
    public String toString() {
        return "\n********Livro**********" +
                "\nTítulo do Livro: " + title +
                "\nAssuntos: " + subjects +
                "\nAutores: " + authors +
                "\nTradutores: " + translators +
                "\nEstante: " + bookshelves +
                "\nLinguagem: " + languages +
                "\nDireitos Autorais: " + copyright +
                "\nTipo de Mídia: " + mediaType + '\'' +
                "\nFormatos: " + formats +
                "\nNumero de Downloads: " + downloadCount +
                '}';
    }
}

