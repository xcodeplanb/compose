package com.makeshop.podbbang.shared.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\nJ$\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/makeshop/podbbang/shared/repository/RankingRepository;", "", "webService", "Lcom/makeshop/podbbang/shared/api/WebService;", "(Lcom/makeshop/podbbang/shared/api/WebService;)V", "categoryList", "Lcom/makeshop/podbbang/shared/api/Resource;", "Lcom/makeshop/podbbang/shared/data/CategoryList;", "isRanking", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rankingList", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lcom/makeshop/podbbang/shared/data/RankingPaging$RankEntity;", "type", "", "categoryId", "shared_debug"})
public final class RankingRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.makeshop.podbbang.shared.api.WebService webService = null;
    
    @javax.inject.Inject()
    public RankingRepository(@org.jetbrains.annotations.NotNull()
    com.makeshop.podbbang.shared.api.WebService webService) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.makeshop.podbbang.shared.data.RankingPaging.RankEntity>> rankingList(@org.jetbrains.annotations.NotNull()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String categoryId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object categoryList(boolean isRanking, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.makeshop.podbbang.shared.api.Resource<com.makeshop.podbbang.shared.data.CategoryList>> $completion) {
        return null;
    }
}