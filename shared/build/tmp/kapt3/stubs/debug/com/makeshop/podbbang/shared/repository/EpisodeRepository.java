package com.makeshop.podbbang.shared.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J8\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\u000eJ>\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/makeshop/podbbang/shared/repository/EpisodeRepository;", "", "webService", "Lcom/makeshop/podbbang/shared/api/WebService;", "(Lcom/makeshop/podbbang/shared/api/WebService;)V", "episodeList", "Lcom/makeshop/podbbang/shared/api/Resource;", "Lcom/makeshop/podbbang/shared/data/EpisodePaging;", "castId", "", "offset", "", "limit", "sort", "(Ljava/lang/String;IILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lcom/makeshop/podbbang/shared/data/EpisodeEntity;", "with", "Companion", "shared_debug"})
public final class EpisodeRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.makeshop.podbbang.shared.api.WebService webService = null;
    public static final int PAGING_LIMIT = 10;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SORT_DESC = "desc";
    @org.jetbrains.annotations.NotNull()
    public static final com.makeshop.podbbang.shared.repository.EpisodeRepository.Companion Companion = null;
    
    @javax.inject.Inject()
    public EpisodeRepository(@org.jetbrains.annotations.NotNull()
    com.makeshop.podbbang.shared.api.WebService webService) {
        super();
    }
    
    /**
     * 정렬을 기준으로 에피소드 목록 조회
     */
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.makeshop.podbbang.shared.data.EpisodeEntity>> episodeList(@org.jetbrains.annotations.NotNull()
    java.lang.String castId, int offset, int limit, @org.jetbrains.annotations.NotNull()
    java.lang.String sort, @org.jetbrains.annotations.NotNull()
    java.lang.String with) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object episodeList(@org.jetbrains.annotations.NotNull()
    java.lang.String castId, int offset, int limit, @org.jetbrains.annotations.NotNull()
    java.lang.String sort, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.makeshop.podbbang.shared.api.Resource<com.makeshop.podbbang.shared.data.EpisodePaging>> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/makeshop/podbbang/shared/repository/EpisodeRepository$Companion;", "", "()V", "PAGING_LIMIT", "", "SORT_DESC", "", "shared_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}