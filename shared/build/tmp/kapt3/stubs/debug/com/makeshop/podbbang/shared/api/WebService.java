package com.makeshop.podbbang.shared.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\nH\'JH\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\n2\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\n2\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\nH\u00a7@\u00a2\u0006\u0002\u0010\u0013J:\u0010\u0014\u001a\u00020\u00152\b\b\u0001\u0010\u0016\u001a\u00020\n2\b\b\u0001\u0010\u0010\u001a\u00020\u000f2\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\n2\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\nH\u00a7@\u00a2\u0006\u0002\u0010\u0019J\u0018\u0010\u001a\u001a\u00020\u001b2\b\b\u0001\u0010\u001c\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u001d\u00a8\u0006\u001e"}, d2 = {"Lcom/makeshop/podbbang/shared/api/WebService;", "", "getCategoryList", "Lcom/makeshop/podbbang/shared/data/CategoryList;", "isRanking", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getConfigurations", "Lcom/makeshop/podbbang/shared/data/AppUpdateResponse;", "appversion", "", "getEpisodeList", "Lcom/makeshop/podbbang/shared/data/EpisodePaging;", "castId", "offset", "", "limit", "sort", "with", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRankingList", "Lcom/makeshop/podbbang/shared/data/RankingPaging;", "type", "categoryId", "next", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecommendCastList", "Lcom/makeshop/podbbang/shared/data/RecommendCastList;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shared_debug"})
public abstract interface WebService {
    
    @retrofit2.http.GET(value = "/configurations")
    @org.jetbrains.annotations.NotNull()
    public abstract com.makeshop.podbbang.shared.data.AppUpdateResponse getConfigurations(@retrofit2.http.Query(value = "appversion")
    @org.jetbrains.annotations.NotNull()
    java.lang.String appversion);
    
    /**
     * 랭킹 목록
     */
    @retrofit2.http.GET(value = "/ranking")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getRankingList(@retrofit2.http.Query(value = "type")
    @org.jetbrains.annotations.NotNull()
    java.lang.String type, @retrofit2.http.Query(value = "limit")
    int limit, @retrofit2.http.Query(value = "category_id")
    @org.jetbrains.annotations.Nullable()
    java.lang.String categoryId, @retrofit2.http.Query(value = "next")
    @org.jetbrains.annotations.Nullable()
    java.lang.String next, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.makeshop.podbbang.shared.data.RankingPaging> $completion);
    
    /**
     * 정렬을 기준으로 에피소드 목록 조회
     * ?with=image 추가 시 에피소드 썸네일이 없는 경우에도 image 수신
     */
    @retrofit2.http.GET(value = "/podcasts/{castid}/episodes/")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getEpisodeList(@retrofit2.http.Path(value = "castid")
    @org.jetbrains.annotations.NotNull()
    java.lang.String castId, @retrofit2.http.Query(value = "offset")
    @org.jetbrains.annotations.Nullable()
    java.lang.Integer offset, @retrofit2.http.Query(value = "limit")
    @org.jetbrains.annotations.Nullable()
    java.lang.Integer limit, @retrofit2.http.Query(value = "sort")
    @org.jetbrains.annotations.Nullable()
    java.lang.String sort, @retrofit2.http.Query(value = "with")
    @org.jetbrains.annotations.Nullable()
    java.lang.String with, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.makeshop.podbbang.shared.data.EpisodePaging> $completion);
    
    @retrofit2.http.POST()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getRecommendCastList(@retrofit2.http.Url()
    @org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.makeshop.podbbang.shared.data.RecommendCastList> $completion);
    
    /**
     * 카테고리 목록
     * isRanking : 랭킹 화면에서 호출했는지 여부
     */
    @retrofit2.http.GET(value = "/categories")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCategoryList(@retrofit2.http.Query(value = "isRanking")
    boolean isRanking, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.makeshop.podbbang.shared.data.CategoryList> $completion);
}