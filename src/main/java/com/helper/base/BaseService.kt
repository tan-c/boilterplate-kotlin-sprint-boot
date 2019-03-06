package com.helper.base

import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException
import org.springframework.transaction.annotation.Transactional

@Service
abstract class BaseService<
    PostRequestModel,
    PutRequestModel,
    ResponseModel : BaseResponseModel,
    E : BaseModel,
    R : BaseRepository<E>
    > : BaseContext<R>() {


    // To pad new customized details for record
    // e.g. for eventEntity or newsEntity in banner
//    open fun getRecordDetails(recordEntity: E): E {
//        return recordEntity
//    }

    open fun getAllRecords(): List<ResponseModel> {
        return repo.findAll().mapNotNull {(it modelOf "") as ResponseModel}
    }
//
//    open fun getAllRecords(searchCriteria: List<SearchCriteria>?, pageParam: PageParamModel): PageModel<ResponseModel> {
//        val pageRequest =
//            PageRequest.of(pageParam.pageIndex - 1, pageParam.pageSize, Sort(Sort.Direction.DESC, "createdAt"))
//
//        val pageLead = repo.findAll(pageRequest)
//        return PageModel(
//            currentPageIndex = pageParam.pageIndex,
//            pageSize = pageParam.pageSize,
//            pageCount = pageLead.totalPages,
//            items = pageLead.content.map { (getRecordDetails(it) modelOf requestLocale) as ResponseModel }
//        )
//    }

    open fun getRecord(recordId: Long): ResponseModel {
        val record = repo.findById(recordId)
        if (record.isPresent) {
            return (record.get() modelOf "") as ResponseModel
        }

        throw EntityNotFoundException("There is no entity exists with id $recordId !")
    }

    // This function could be overwritten in the child classes
    open fun getCreatedRecordEntity(recordRequest: PostRequestModel): BaseModel {
        return BaseModel()
        // setCreator currentUser
    }

    @Transactional(readOnly = false)
    open fun createRecord(recordRequest: PostRequestModel): ResponseModel {
        val recordEntity = getCreatedRecordEntity(recordRequest)
        em.persist(recordEntity)
        em.flush()
        return (recordEntity modelOf "") as ResponseModel
    }

    // This function could be overwritten in the child classes
    open fun getUpdatedRecordEntity(recordId: Long, recordRequest: PutRequestModel): BaseModel {
        return getEntity<E>(recordId)
    }

    @Transactional(readOnly = false)
    open fun updateRecord(recordId: Long, recordRequest: PutRequestModel): BaseDataResponseModel {
        val recordEntity = getUpdatedRecordEntity(recordId, recordRequest)
//        recordEntity setUpdator currentUser
        em.persist(recordEntity)
        em.flush()
        return (recordEntity modelOf "") as BaseDataResponseModel
    }

    @Transactional(readOnly = false)
    open fun deleteRecord(recordId: Long): BaseDeletedDataResponseModel {
        val recordEntity = getEntityOrNull<E>(recordId)
        recordEntity?.let {
            em.remove(recordEntity)
            em.flush()
        }
        return BaseDeletedDataResponseModel(recordId)
    }

    fun <E : BaseModel> getEntity(id: Long, repo: BaseRepository<E>? = null): E {
        val enRepo: BaseRepository<E> = repo ?: this.repo as BaseRepository<E>
        val entity = enRepo.findById(id)
        return if (entity.isPresent)
            entity.get()
        else
            throw EntityNotFoundException("There is no entity exists with id $id !")
    }

    fun <E : BaseModel> getEntityOrNull(id: Long, repo: BaseRepository<E>? = null): E? {
        val enRepo: BaseRepository<E> = repo ?: this.repo as BaseRepository<E>
        val entity = enRepo.findById(id)
        return if (entity.isPresent) entity.get() else null
    }
}
