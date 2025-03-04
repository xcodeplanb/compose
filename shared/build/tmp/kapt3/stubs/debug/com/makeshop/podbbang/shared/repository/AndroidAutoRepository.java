package com.makeshop.podbbang.shared.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0006J\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/makeshop/podbbang/shared/repository/AndroidAutoRepository;", "", "webService", "Lcom/makeshop/podbbang/shared/api/WebService;", "(Lcom/makeshop/podbbang/shared/api/WebService;)V", "getBuyEpisodeList", "", "getDownloadList", "getEpisodeList", "getLiveOnList", "recommendCastList", "Lcom/makeshop/podbbang/shared/api/Resource;", "Lcom/makeshop/podbbang/shared/data/RecommendCastList;", "url", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shared_debug"})
public final class AndroidAutoRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.makeshop.podbbang.shared.api.WebService webService = null;
    
    @javax.inject.Inject()
    public AndroidAutoRepository(@org.jetbrains.annotations.NotNull()
    com.makeshop.podbbang.shared.api.WebService webService) {
        super();
    }
    
    /**
     * 구매 에피소드 리스트
     */
    public final void getBuyEpisodeList() {
    }
    
    /**
     * 로그인 사용자, 다운로드
     */
    public final void getDownloadList() {
    }
    
    /**
     * 라이브 방송
     */
    public final void getLiveOnList() {
    }
    
    /**
     * 에피소드 리스트
     */
    public final void getEpisodeList() {
    }
    
    /**
     * 추천 캐스트 리스트
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object recommendCastList(@org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.makeshop.podbbang.shared.api.Resource<com.makeshop.podbbang.shared.data.RecommendCastList>> $completion) {
        return null;
    }
}