package com.makeshop.podbbang.shared.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001dB=\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0002\u0010\fJ\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0017H\u0016J(\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u001bH\u0096@\u00a2\u0006\u0002\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\t\u001a\u0004\u0018\u00010\b\u00a2\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000e\u00a8\u0006\u001e"}, d2 = {"Lcom/makeshop/podbbang/shared/repository/EpisodePagingSource;", "Landroidx/paging/PagingSource;", "", "Lcom/makeshop/podbbang/shared/data/EpisodeEntity;", "webService", "Lcom/makeshop/podbbang/shared/api/WebService;", "castId", "offset", "", "limit", "sort", "with", "(Lcom/makeshop/podbbang/shared/api/WebService;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getCastId", "()Ljava/lang/String;", "getLimit", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOffset", "getSort", "getWith", "getRefreshKey", "state", "Landroidx/paging/PagingState;", "load", "Landroidx/paging/PagingSource$LoadResult;", "params", "Landroidx/paging/PagingSource$LoadParams;", "(Landroidx/paging/PagingSource$LoadParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "shared_debug"})
public final class EpisodePagingSource extends androidx.paging.PagingSource<java.lang.String, com.makeshop.podbbang.shared.data.EpisodeEntity> {
    @org.jetbrains.annotations.NotNull()
    private final com.makeshop.podbbang.shared.api.WebService webService = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String castId = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer offset = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer limit = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String sort = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String with = null;
    public static final int PAGE_SIZE = 20;
    public static final int LIMIT_SIZE = 50;
    @org.jetbrains.annotations.NotNull()
    public static final com.makeshop.podbbang.shared.repository.EpisodePagingSource.Companion Companion = null;
    
    public EpisodePagingSource(@org.jetbrains.annotations.NotNull()
    com.makeshop.podbbang.shared.api.WebService webService, @org.jetbrains.annotations.NotNull()
    java.lang.String castId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer offset, @org.jetbrains.annotations.Nullable()
    java.lang.Integer limit, @org.jetbrains.annotations.Nullable()
    java.lang.String sort, @org.jetbrains.annotations.Nullable()
    java.lang.String with) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCastId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getOffset() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getLimit() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSort() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getWith() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object load(@org.jetbrains.annotations.NotNull()
    androidx.paging.PagingSource.LoadParams<java.lang.String> params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super androidx.paging.PagingSource.LoadResult<java.lang.String, com.makeshop.podbbang.shared.data.EpisodeEntity>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.String getRefreshKey(@org.jetbrains.annotations.NotNull()
    androidx.paging.PagingState<java.lang.String, com.makeshop.podbbang.shared.data.EpisodeEntity> state) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/makeshop/podbbang/shared/repository/EpisodePagingSource$Companion;", "", "()V", "LIMIT_SIZE", "", "PAGE_SIZE", "shared_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}