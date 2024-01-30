package com.agvber.network.model


import com.squareup.moshi.Json

data class PhotoDetailResponse(
    @Json(name = "id")
    val id: String,
    @Json(name = "slug")
    val slug: String,
    @Json(name = "created_at")
    val createdAt: String,
    @Json(name = "updated_at")
    val updatedAt: String,
    @Json(name = "promoted_at")
    val promotedAt: String,
    @Json(name = "width")
    val width: Int,
    @Json(name = "height")
    val height: Int,
    @Json(name = "color")
    val color: String,
    @Json(name = "blur_hash")
    val blurHash: String,
    @Json(name = "description")
    val description: String?,
    @Json(name = "alt_description")
    val altDescription: String,
//    @Json(name = "breadcrumbs")
//    val breadcrumbs: List<Any>,
    @Json(name = "urls")
    val urls: Urls,
    @Json(name = "links")
    val links: Links,
    @Json(name = "likes")
    val likes: Int,
    @Json(name = "liked_by_user")
    val likedByUser: Boolean,
//    @Json(name = "current_user_collections")
//    val currentUserCollections: List<Any>,
//    @Json(name = "sponsorship")
//    val sponsorship: Any?,
    @Json(name = "topic_submissions")
    val topicSubmissions: TopicSubmissions,
    @Json(name = "user")
    val user: User,
    @Json(name = "exif")
    val exif: Exif,
    @Json(name = "location")
    val location: Location,
    @Json(name = "meta")
    val meta: Meta,
    @Json(name = "public_domain")
    val publicDomain: Boolean,
    @Json(name = "tags")
    val tags: List<Tag>,
    @Json(name = "tags_preview")
    val tagsPreview: List<TagsPreview>,
    @Json(name = "views")
    val views: Int,
    @Json(name = "downloads")
    val downloads: Int,
//    @Json(name = "topics")
//    val topics: List<Any>,
    @Json(name = "related_collections")
    val relatedCollections: RelatedCollections
) {
    data class Urls(
        @Json(name = "raw")
        val raw: String,
        @Json(name = "full")
        val full: String,
        @Json(name = "regular")
        val regular: String,
        @Json(name = "small")
        val small: String,
        @Json(name = "thumb")
        val thumb: String,
        @Json(name = "small_s3")
        val smallS3: String
    )

    data class Links(
        @Json(name = "self")
        val self: String,
        @Json(name = "html")
        val html: String,
        @Json(name = "download")
        val download: String,
        @Json(name = "download_location")
        val downloadLocation: String
    )

    data class TopicSubmissions(
        @Json(name = "spirituality")
        val spirituality: Spirituality,
        @Json(name = "travel")
        val travel: Travel,
        @Json(name = "wallpapers")
        val wallpapers: Wallpapers
    ) {
        data class Spirituality(
            @Json(name = "status")
            val status: String
        )

        data class Travel(
            @Json(name = "status")
            val status: String
        )

        data class Wallpapers(
            @Json(name = "status")
            val status: String
        )
    }

    data class User(
        @Json(name = "id")
        val id: String,
        @Json(name = "updated_at")
        val updatedAt: String,
        @Json(name = "username")
        val username: String,
        @Json(name = "name")
        val name: String,
        @Json(name = "first_name")
        val firstName: String,
        @Json(name = "last_name")
        val lastName: String,
        @Json(name = "twitter_username")
        val twitterUsername: String?,
        @Json(name = "portfolio_url")
        val portfolioUrl: String,
        @Json(name = "bio")
        val bio: String,
        @Json(name = "location")
        val location: String,
        @Json(name = "links")
        val links: Links,
        @Json(name = "profile_image")
        val profileImage: ProfileImage,
        @Json(name = "instagram_username")
        val instagramUsername: String?,
        @Json(name = "total_collections")
        val totalCollections: Int,
        @Json(name = "total_likes")
        val totalLikes: Int,
        @Json(name = "total_photos")
        val totalPhotos: Int,
        @Json(name = "total_promoted_photos")
        val totalPromotedPhotos: Int,
        @Json(name = "accepted_tos")
        val acceptedTos: Boolean,
        @Json(name = "for_hire")
        val forHire: Boolean,
        @Json(name = "social")
        val social: Social
    ) {
        data class Links(
            @Json(name = "self")
            val self: String,
            @Json(name = "html")
            val html: String,
            @Json(name = "photos")
            val photos: String,
            @Json(name = "likes")
            val likes: String,
            @Json(name = "portfolio")
            val portfolio: String,
            @Json(name = "following")
            val following: String,
            @Json(name = "followers")
            val followers: String
        )

        data class ProfileImage(
            @Json(name = "small")
            val small: String,
            @Json(name = "medium")
            val medium: String,
            @Json(name = "large")
            val large: String
        )

        data class Social(
            @Json(name = "instagram_username")
            val instagramUsername: String?,
            @Json(name = "portfolio_url")
            val portfolioUrl: String,
            @Json(name = "twitter_username")
            val twitterUsername: String?,
            @Json(name = "paypal_email")
            val paypalEmail: String?
        )
    }

    data class Exif(
        @Json(name = "make")
        val make: String?,
        @Json(name = "model")
        val model: String?,
        @Json(name = "name")
        val name: String?,
        @Json(name = "exposure_time")
        val exposureTime: String?,
        @Json(name = "aperture")
        val aperture: String?,
        @Json(name = "focal_length")
        val focalLength: String?,
        @Json(name = "iso")
        val iso: Int?
    )

    data class Location(
        @Json(name = "name")
        val name: String?,
        @Json(name = "city")
        val city: String?,
        @Json(name = "country")
        val country: String?,
        @Json(name = "position")
        val position: Position
    ) {
        data class Position(
            @Json(name = "latitude")
            val latitude: Double?,
            @Json(name = "longitude")
            val longitude: Double?
        )
    }

    data class Meta(
        @Json(name = "index")
        val index: Boolean
    )

    data class Tag(
        @Json(name = "type")
        val type: String,
        @Json(name = "title")
        val title: String,
        @Json(name = "source")
        val source: Source?
    ) {
        data class Source(
            @Json(name = "ancestry")
            val ancestry: Ancestry,
            @Json(name = "title")
            val title: String,
            @Json(name = "subtitle")
            val subtitle: String,
            @Json(name = "description")
            val description: String,
            @Json(name = "meta_title")
            val metaTitle: String,
            @Json(name = "meta_description")
            val metaDescription: String,
            @Json(name = "cover_photo")
            val coverPhoto: CoverPhoto
        ) {
            data class Ancestry(
                @Json(name = "type")
                val type: Type,
                @Json(name = "category")
                val category: Category,
                @Json(name = "subcategory")
                val subcategory: Subcategory?
            ) {
                data class Type(
                    @Json(name = "slug")
                    val slug: String,
                    @Json(name = "pretty_slug")
                    val prettySlug: String
                )

                data class Category(
                    @Json(name = "slug")
                    val slug: String,
                    @Json(name = "pretty_slug")
                    val prettySlug: String
                )

                data class Subcategory(
                    @Json(name = "slug")
                    val slug: String,
                    @Json(name = "pretty_slug")
                    val prettySlug: String
                )
            }

            data class CoverPhoto(
                @Json(name = "id")
                val id: String,
                @Json(name = "slug")
                val slug: String,
                @Json(name = "created_at")
                val createdAt: String,
                @Json(name = "updated_at")
                val updatedAt: String,
                @Json(name = "promoted_at")
                val promotedAt: String?,
                @Json(name = "width")
                val width: Int,
                @Json(name = "height")
                val height: Int,
                @Json(name = "color")
                val color: String,
                @Json(name = "blur_hash")
                val blurHash: String,
                @Json(name = "description")
                val description: String?,
                @Json(name = "alt_description")
                val altDescription: String,
                @Json(name = "breadcrumbs")
                val breadcrumbs: List<Breadcrumb>,
                @Json(name = "urls")
                val urls: Urls,
                @Json(name = "links")
                val links: Links,
                @Json(name = "likes")
                val likes: Int,
                @Json(name = "liked_by_user")
                val likedByUser: Boolean,
//                @Json(name = "current_user_collections")
//                val currentUserCollections: List<Any>,
//                @Json(name = "sponsorship")
//                val sponsorship: Any?,
                @Json(name = "topic_submissions")
                val topicSubmissions: TopicSubmissions?,
                @Json(name = "premium")
                val premium: Boolean?,
                @Json(name = "plus")
                val plus: Boolean?,
                @Json(name = "user")
                val user: User
            ) {
                data class Breadcrumb(
                    @Json(name = "slug")
                    val slug: String,
                    @Json(name = "title")
                    val title: String,
                    @Json(name = "index")
                    val index: Int,
                    @Json(name = "type")
                    val type: String
                )

                data class Urls(
                    @Json(name = "raw")
                    val raw: String,
                    @Json(name = "full")
                    val full: String,
                    @Json(name = "regular")
                    val regular: String,
                    @Json(name = "small")
                    val small: String,
                    @Json(name = "thumb")
                    val thumb: String,
                    @Json(name = "small_s3")
                    val smallS3: String
                )

                data class Links(
                    @Json(name = "self")
                    val self: String,
                    @Json(name = "html")
                    val html: String,
                    @Json(name = "download")
                    val download: String,
                    @Json(name = "download_location")
                    val downloadLocation: String
                )

                data class TopicSubmissions(
                    @Json(name = "nature")
                    val nature: Nature?
                ) {
                    data class Nature(
                        @Json(name = "status")
                        val status: String,
                        @Json(name = "approved_on")
                        val approvedOn: String
                    )
                }

                data class User(
                    @Json(name = "id")
                    val id: String,
                    @Json(name = "updated_at")
                    val updatedAt: String,
                    @Json(name = "username")
                    val username: String,
                    @Json(name = "name")
                    val name: String,
                    @Json(name = "first_name")
                    val firstName: String,
                    @Json(name = "last_name")
                    val lastName: String,
                    @Json(name = "twitter_username")
                    val twitterUsername: String?,
                    @Json(name = "portfolio_url")
                    val portfolioUrl: String?,
                    @Json(name = "bio")
                    val bio: String?,
                    @Json(name = "location")
                    val location: String?,
                    @Json(name = "links")
                    val links: Links,
                    @Json(name = "profile_image")
                    val profileImage: ProfileImage,
                    @Json(name = "instagram_username")
                    val instagramUsername: String?,
                    @Json(name = "total_collections")
                    val totalCollections: Int,
                    @Json(name = "total_likes")
                    val totalLikes: Int,
                    @Json(name = "total_photos")
                    val totalPhotos: Int,
                    @Json(name = "total_promoted_photos")
                    val totalPromotedPhotos: Int,
                    @Json(name = "accepted_tos")
                    val acceptedTos: Boolean,
                    @Json(name = "for_hire")
                    val forHire: Boolean,
                    @Json(name = "social")
                    val social: Social
                ) {
                    data class Links(
                        @Json(name = "self")
                        val self: String,
                        @Json(name = "html")
                        val html: String,
                        @Json(name = "photos")
                        val photos: String,
                        @Json(name = "likes")
                        val likes: String,
                        @Json(name = "portfolio")
                        val portfolio: String,
                        @Json(name = "following")
                        val following: String,
                        @Json(name = "followers")
                        val followers: String
                    )

                    data class ProfileImage(
                        @Json(name = "small")
                        val small: String,
                        @Json(name = "medium")
                        val medium: String,
                        @Json(name = "large")
                        val large: String
                    )

                    data class Social(
                        @Json(name = "instagram_username")
                        val instagramUsername: String?,
                        @Json(name = "portfolio_url")
                        val portfolioUrl: String?,
                        @Json(name = "twitter_username")
                        val twitterUsername: String?,
                        @Json(name = "paypal_email")
                        val paypalEmail: String?
                    )
                }
            }
        }
    }

    data class TagsPreview(
        @Json(name = "type")
        val type: String,
        @Json(name = "title")
        val title: String,
        @Json(name = "source")
        val source: Source?
    ) {
        data class Source(
            @Json(name = "ancestry")
            val ancestry: Ancestry,
            @Json(name = "title")
            val title: String,
            @Json(name = "subtitle")
            val subtitle: String,
            @Json(name = "description")
            val description: String,
            @Json(name = "meta_title")
            val metaTitle: String,
            @Json(name = "meta_description")
            val metaDescription: String,
            @Json(name = "cover_photo")
            val coverPhoto: CoverPhoto
        ) {
            data class Ancestry(
                @Json(name = "type")
                val type: Type,
                @Json(name = "category")
                val category: Category,
                @Json(name = "subcategory")
                val subcategory: Subcategory?
            ) {
                data class Type(
                    @Json(name = "slug")
                    val slug: String,
                    @Json(name = "pretty_slug")
                    val prettySlug: String
                )

                data class Category(
                    @Json(name = "slug")
                    val slug: String,
                    @Json(name = "pretty_slug")
                    val prettySlug: String
                )

                data class Subcategory(
                    @Json(name = "slug")
                    val slug: String,
                    @Json(name = "pretty_slug")
                    val prettySlug: String
                )
            }

            data class CoverPhoto(
                @Json(name = "id")
                val id: String,
                @Json(name = "slug")
                val slug: String,
                @Json(name = "created_at")
                val createdAt: String,
                @Json(name = "updated_at")
                val updatedAt: String,
                @Json(name = "promoted_at")
                val promotedAt: String,
                @Json(name = "width")
                val width: Int,
                @Json(name = "height")
                val height: Int,
                @Json(name = "color")
                val color: String,
                @Json(name = "blur_hash")
                val blurHash: String,
                @Json(name = "description")
                val description: String,
                @Json(name = "alt_description")
                val altDescription: String,
                @Json(name = "breadcrumbs")
                val breadcrumbs: List<Breadcrumb>,
                @Json(name = "urls")
                val urls: Urls,
                @Json(name = "links")
                val links: Links,
                @Json(name = "likes")
                val likes: Int,
                @Json(name = "liked_by_user")
                val likedByUser: Boolean,
//                @Json(name = "current_user_collections")
//                val currentUserCollections: List<Any>,
//                @Json(name = "sponsorship")
//                val sponsorship: Any?,
                @Json(name = "topic_submissions")
                val topicSubmissions: TopicSubmissions?,
                @Json(name = "premium")
                val premium: Boolean?,
                @Json(name = "plus")
                val plus: Boolean?,
                @Json(name = "user")
                val user: User
            ) {
                data class Breadcrumb(
                    @Json(name = "slug")
                    val slug: String,
                    @Json(name = "title")
                    val title: String,
                    @Json(name = "index")
                    val index: Int,
                    @Json(name = "type")
                    val type: String
                )

                data class Urls(
                    @Json(name = "raw")
                    val raw: String,
                    @Json(name = "full")
                    val full: String,
                    @Json(name = "regular")
                    val regular: String,
                    @Json(name = "small")
                    val small: String,
                    @Json(name = "thumb")
                    val thumb: String,
                    @Json(name = "small_s3")
                    val smallS3: String
                )

                data class Links(
                    @Json(name = "self")
                    val self: String,
                    @Json(name = "html")
                    val html: String,
                    @Json(name = "download")
                    val download: String,
                    @Json(name = "download_location")
                    val downloadLocation: String
                )

                data class TopicSubmissions(
                    @Json(name = "nature")
                    val nature: Nature?
                ) {
                    data class Nature(
                        @Json(name = "status")
                        val status: String,
                        @Json(name = "approved_on")
                        val approvedOn: String
                    )
                }

                data class User(
                    @Json(name = "id")
                    val id: String,
                    @Json(name = "updated_at")
                    val updatedAt: String,
                    @Json(name = "username")
                    val username: String,
                    @Json(name = "name")
                    val name: String,
                    @Json(name = "first_name")
                    val firstName: String,
                    @Json(name = "last_name")
                    val lastName: String,
                    @Json(name = "twitter_username")
                    val twitterUsername: String?,
                    @Json(name = "portfolio_url")
                    val portfolioUrl: String?,
                    @Json(name = "bio")
                    val bio: String,
                    @Json(name = "location")
                    val location: String?,
                    @Json(name = "links")
                    val links: Links,
                    @Json(name = "profile_image")
                    val profileImage: ProfileImage,
                    @Json(name = "instagram_username")
                    val instagramUsername: String?,
                    @Json(name = "total_collections")
                    val totalCollections: Int,
                    @Json(name = "total_likes")
                    val totalLikes: Int,
                    @Json(name = "total_photos")
                    val totalPhotos: Int,
                    @Json(name = "total_promoted_photos")
                    val totalPromotedPhotos: Int,
                    @Json(name = "accepted_tos")
                    val acceptedTos: Boolean,
                    @Json(name = "for_hire")
                    val forHire: Boolean,
                    @Json(name = "social")
                    val social: Social
                ) {
                    data class Links(
                        @Json(name = "self")
                        val self: String,
                        @Json(name = "html")
                        val html: String,
                        @Json(name = "photos")
                        val photos: String,
                        @Json(name = "likes")
                        val likes: String,
                        @Json(name = "portfolio")
                        val portfolio: String,
                        @Json(name = "following")
                        val following: String,
                        @Json(name = "followers")
                        val followers: String
                    )

                    data class ProfileImage(
                        @Json(name = "small")
                        val small: String,
                        @Json(name = "medium")
                        val medium: String,
                        @Json(name = "large")
                        val large: String
                    )

                    data class Social(
                        @Json(name = "instagram_username")
                        val instagramUsername: String?,
                        @Json(name = "portfolio_url")
                        val portfolioUrl: String?,
                        @Json(name = "twitter_username")
                        val twitterUsername: String?,
                        @Json(name = "paypal_email")
                        val paypalEmail: String?
                    )
                }
            }
        }
    }

    data class RelatedCollections(
        @Json(name = "total")
        val total: Int,
        @Json(name = "type")
        val type: String,
        @Json(name = "results")
        val results: List<Result>
    ) {
        data class Result(
            @Json(name = "id")
            val id: String,
            @Json(name = "title")
            val title: String,
            @Json(name = "description")
            val description: String?,
            @Json(name = "published_at")
            val publishedAt: String,
            @Json(name = "last_collected_at")
            val lastCollectedAt: String,
            @Json(name = "updated_at")
            val updatedAt: String,
            @Json(name = "featured")
            val featured: Boolean,
            @Json(name = "total_photos")
            val totalPhotos: Int,
            @Json(name = "private")
            val `private`: Boolean,
            @Json(name = "share_key")
            val shareKey: String,
            @Json(name = "tags")
            val tags: List<Tag>,
            @Json(name = "links")
            val links: Links,
            @Json(name = "user")
            val user: User,
            @Json(name = "cover_photo")
            val coverPhoto: CoverPhoto,
            @Json(name = "preview_photos")
            val previewPhotos: List<PreviewPhoto>
        ) {
            data class Tag(
                @Json(name = "type")
                val type: String,
                @Json(name = "title")
                val title: String,
                @Json(name = "source")
                val source: Source?
            ) {
                data class Source(
                    @Json(name = "ancestry")
                    val ancestry: Ancestry,
                    @Json(name = "title")
                    val title: String,
                    @Json(name = "subtitle")
                    val subtitle: String,
                    @Json(name = "description")
                    val description: String,
                    @Json(name = "meta_title")
                    val metaTitle: String,
                    @Json(name = "meta_description")
                    val metaDescription: String,
                    @Json(name = "cover_photo")
                    val coverPhoto: CoverPhoto
                ) {
                    data class Ancestry(
                        @Json(name = "type")
                        val type: Type,
                        @Json(name = "category")
                        val category: Category?,
                        @Json(name = "subcategory")
                        val subcategory: Subcategory?
                    ) {
                        data class Type(
                            @Json(name = "slug")
                            val slug: String,
                            @Json(name = "pretty_slug")
                            val prettySlug: String
                        )

                        data class Category(
                            @Json(name = "slug")
                            val slug: String,
                            @Json(name = "pretty_slug")
                            val prettySlug: String
                        )

                        data class Subcategory(
                            @Json(name = "slug")
                            val slug: String,
                            @Json(name = "pretty_slug")
                            val prettySlug: String
                        )
                    }

                    data class CoverPhoto(
                        @Json(name = "id")
                        val id: String,
                        @Json(name = "slug")
                        val slug: String,
                        @Json(name = "created_at")
                        val createdAt: String,
                        @Json(name = "updated_at")
                        val updatedAt: String,
                        @Json(name = "promoted_at")
                        val promotedAt: String?,
                        @Json(name = "width")
                        val width: Int,
                        @Json(name = "height")
                        val height: Int,
                        @Json(name = "color")
                        val color: String,
                        @Json(name = "blur_hash")
                        val blurHash: String,
                        @Json(name = "description")
                        val description: String?,
                        @Json(name = "alt_description")
                        val altDescription: String,
                        @Json(name = "breadcrumbs")
                        val breadcrumbs: List<Breadcrumb>,
                        @Json(name = "urls")
                        val urls: Urls,
                        @Json(name = "links")
                        val links: Links,
                        @Json(name = "likes")
                        val likes: Int,
                        @Json(name = "liked_by_user")
                        val likedByUser: Boolean,
//                        @Json(name = "current_user_collections")
//                        val currentUserCollections: List<Any>,
//                        @Json(name = "sponsorship")
//                        val sponsorship: Any?,
                        @Json(name = "topic_submissions")
                        val topicSubmissions: TopicSubmissions?,
                        @Json(name = "premium")
                        val premium: Boolean?,
                        @Json(name = "plus")
                        val plus: Boolean?,
                        @Json(name = "user")
                        val user: User
                    ) {
                        data class Breadcrumb(
                            @Json(name = "slug")
                            val slug: String,
                            @Json(name = "title")
                            val title: String,
                            @Json(name = "index")
                            val index: Int,
                            @Json(name = "type")
                            val type: String
                        )

                        data class Urls(
                            @Json(name = "raw")
                            val raw: String,
                            @Json(name = "full")
                            val full: String,
                            @Json(name = "regular")
                            val regular: String,
                            @Json(name = "small")
                            val small: String,
                            @Json(name = "thumb")
                            val thumb: String,
                            @Json(name = "small_s3")
                            val smallS3: String
                        )

                        data class Links(
                            @Json(name = "self")
                            val self: String,
                            @Json(name = "html")
                            val html: String,
                            @Json(name = "download")
                            val download: String,
                            @Json(name = "download_location")
                            val downloadLocation: String
                        )

                        data class TopicSubmissions(
                            @Json(name = "nature")
                            val nature: Nature?,
                            @Json(name = "wallpapers")
                            val wallpapers: Wallpapers?
                        ) {
                            data class Nature(
                                @Json(name = "status")
                                val status: String,
                                @Json(name = "approved_on")
                                val approvedOn: String
                            )

                            data class Wallpapers(
                                @Json(name = "status")
                                val status: String,
                                @Json(name = "approved_on")
                                val approvedOn: String
                            )
                        }

                        data class User(
                            @Json(name = "id")
                            val id: String,
                            @Json(name = "updated_at")
                            val updatedAt: String,
                            @Json(name = "username")
                            val username: String,
                            @Json(name = "name")
                            val name: String,
                            @Json(name = "first_name")
                            val firstName: String,
                            @Json(name = "last_name")
                            val lastName: String,
                            @Json(name = "twitter_username")
                            val twitterUsername: String?,
                            @Json(name = "portfolio_url")
                            val portfolioUrl: String,
                            @Json(name = "bio")
                            val bio: String?,
                            @Json(name = "location")
                            val location: String?,
                            @Json(name = "links")
                            val links: Links,
                            @Json(name = "profile_image")
                            val profileImage: ProfileImage,
                            @Json(name = "instagram_username")
                            val instagramUsername: String?,
                            @Json(name = "total_collections")
                            val totalCollections: Int,
                            @Json(name = "total_likes")
                            val totalLikes: Int,
                            @Json(name = "total_photos")
                            val totalPhotos: Int,
                            @Json(name = "total_promoted_photos")
                            val totalPromotedPhotos: Int,
                            @Json(name = "accepted_tos")
                            val acceptedTos: Boolean,
                            @Json(name = "for_hire")
                            val forHire: Boolean,
                            @Json(name = "social")
                            val social: Social
                        ) {
                            data class Links(
                                @Json(name = "self")
                                val self: String,
                                @Json(name = "html")
                                val html: String,
                                @Json(name = "photos")
                                val photos: String,
                                @Json(name = "likes")
                                val likes: String,
                                @Json(name = "portfolio")
                                val portfolio: String,
                                @Json(name = "following")
                                val following: String,
                                @Json(name = "followers")
                                val followers: String
                            )

                            data class ProfileImage(
                                @Json(name = "small")
                                val small: String,
                                @Json(name = "medium")
                                val medium: String,
                                @Json(name = "large")
                                val large: String
                            )

                            data class Social(
                                @Json(name = "instagram_username")
                                val instagramUsername: String?,
                                @Json(name = "portfolio_url")
                                val portfolioUrl: String,
                                @Json(name = "twitter_username")
                                val twitterUsername: String?,
                                @Json(name = "paypal_email")
                                val paypalEmail: String?
                            )
                        }
                    }
                }
            }

            data class Links(
                @Json(name = "self")
                val self: String,
                @Json(name = "html")
                val html: String,
                @Json(name = "photos")
                val photos: String,
                @Json(name = "related")
                val related: String
            )

            data class User(
                @Json(name = "id")
                val id: String,
                @Json(name = "updated_at")
                val updatedAt: String,
                @Json(name = "username")
                val username: String,
                @Json(name = "name")
                val name: String,
                @Json(name = "first_name")
                val firstName: String,
                @Json(name = "last_name")
                val lastName: String,
                @Json(name = "twitter_username")
                val twitterUsername: String?,
                @Json(name = "portfolio_url")
                val portfolioUrl: String?,
                @Json(name = "bio")
                val bio: String?,
                @Json(name = "location")
                val location: String?,
                @Json(name = "links")
                val links: Links,
                @Json(name = "profile_image")
                val profileImage: ProfileImage,
                @Json(name = "instagram_username")
                val instagramUsername: String?,
                @Json(name = "total_collections")
                val totalCollections: Int,
                @Json(name = "total_likes")
                val totalLikes: Int,
                @Json(name = "total_photos")
                val totalPhotos: Int,
                @Json(name = "total_promoted_photos")
                val totalPromotedPhotos: Int,
                @Json(name = "accepted_tos")
                val acceptedTos: Boolean,
                @Json(name = "for_hire")
                val forHire: Boolean,
                @Json(name = "social")
                val social: Social
            ) {
                data class Links(
                    @Json(name = "self")
                    val self: String,
                    @Json(name = "html")
                    val html: String,
                    @Json(name = "photos")
                    val photos: String,
                    @Json(name = "likes")
                    val likes: String,
                    @Json(name = "portfolio")
                    val portfolio: String,
                    @Json(name = "following")
                    val following: String,
                    @Json(name = "followers")
                    val followers: String
                )

                data class ProfileImage(
                    @Json(name = "small")
                    val small: String,
                    @Json(name = "medium")
                    val medium: String,
                    @Json(name = "large")
                    val large: String
                )

                data class Social(
                    @Json(name = "instagram_username")
                    val instagramUsername: String?,
                    @Json(name = "portfolio_url")
                    val portfolioUrl: String?,
                    @Json(name = "twitter_username")
                    val twitterUsername: String?,
                    @Json(name = "paypal_email")
                    val paypalEmail: String?
                )
            }

            data class CoverPhoto(
                @Json(name = "id")
                val id: String,
                @Json(name = "slug")
                val slug: String,
                @Json(name = "created_at")
                val createdAt: String,
                @Json(name = "updated_at")
                val updatedAt: String,
                @Json(name = "promoted_at")
                val promotedAt: String?,
                @Json(name = "width")
                val width: Int,
                @Json(name = "height")
                val height: Int,
                @Json(name = "color")
                val color: String,
                @Json(name = "blur_hash")
                val blurHash: String,
                @Json(name = "description")
                val description: String?,
                @Json(name = "alt_description")
                val altDescription: String,
//                @Json(name = "breadcrumbs")
//                val breadcrumbs: List<Any>,
                @Json(name = "urls")
                val urls: Urls,
                @Json(name = "links")
                val links: Links,
                @Json(name = "likes")
                val likes: Int,
                @Json(name = "liked_by_user")
                val likedByUser: Boolean,
//                @Json(name = "current_user_collections")
//                val currentUserCollections: List<Any>,
//                @Json(name = "sponsorship")
//                val sponsorship: Any?,
                @Json(name = "topic_submissions")
                val topicSubmissions: TopicSubmissions?,
                @Json(name = "user")
                val user: User
            ) {
                data class Urls(
                    @Json(name = "raw")
                    val raw: String,
                    @Json(name = "full")
                    val full: String,
                    @Json(name = "regular")
                    val regular: String,
                    @Json(name = "small")
                    val small: String,
                    @Json(name = "thumb")
                    val thumb: String,
                    @Json(name = "small_s3")
                    val smallS3: String
                )

                data class Links(
                    @Json(name = "self")
                    val self: String,
                    @Json(name = "html")
                    val html: String,
                    @Json(name = "download")
                    val download: String,
                    @Json(name = "download_location")
                    val downloadLocation: String
                )

                data class TopicSubmissions(
                    @Json(name = "textures-patterns")
                    val texturesPatterns: TexturesPatterns?,
                    @Json(name = "architecture-interior")
                    val architectureInterior: ArchitectureInterior?,
                    @Json(name = "nature")
                    val nature: Nature?,
                    @Json(name = "wallpapers")
                    val wallpapers: Wallpapers?
                ) {
                    data class TexturesPatterns(
                        @Json(name = "status")
                        val status: String
                    )

                    data class ArchitectureInterior(
                        @Json(name = "status")
                        val status: String,
                        @Json(name = "approved_on")
                        val approvedOn: String
                    )

                    data class Nature(
                        @Json(name = "status")
                        val status: String
                    )

                    data class Wallpapers(
                        @Json(name = "status")
                        val status: String
                    )
                }

                data class User(
                    @Json(name = "id")
                    val id: String,
                    @Json(name = "updated_at")
                    val updatedAt: String,
                    @Json(name = "username")
                    val username: String,
                    @Json(name = "name")
                    val name: String,
                    @Json(name = "first_name")
                    val firstName: String,
                    @Json(name = "last_name")
                    val lastName: String,
                    @Json(name = "twitter_username")
                    val twitterUsername: String?,
                    @Json(name = "portfolio_url")
                    val portfolioUrl: String?,
                    @Json(name = "bio")
                    val bio: String,
                    @Json(name = "location")
                    val location: String,
                    @Json(name = "links")
                    val links: Links,
                    @Json(name = "profile_image")
                    val profileImage: ProfileImage,
                    @Json(name = "instagram_username")
                    val instagramUsername: String,
                    @Json(name = "total_collections")
                    val totalCollections: Int,
                    @Json(name = "total_likes")
                    val totalLikes: Int,
                    @Json(name = "total_photos")
                    val totalPhotos: Int,
                    @Json(name = "total_promoted_photos")
                    val totalPromotedPhotos: Int,
                    @Json(name = "accepted_tos")
                    val acceptedTos: Boolean,
                    @Json(name = "for_hire")
                    val forHire: Boolean,
                    @Json(name = "social")
                    val social: Social
                ) {
                    data class Links(
                        @Json(name = "self")
                        val self: String,
                        @Json(name = "html")
                        val html: String,
                        @Json(name = "photos")
                        val photos: String,
                        @Json(name = "likes")
                        val likes: String,
                        @Json(name = "portfolio")
                        val portfolio: String,
                        @Json(name = "following")
                        val following: String,
                        @Json(name = "followers")
                        val followers: String
                    )

                    data class ProfileImage(
                        @Json(name = "small")
                        val small: String,
                        @Json(name = "medium")
                        val medium: String,
                        @Json(name = "large")
                        val large: String
                    )

                    data class Social(
                        @Json(name = "instagram_username")
                        val instagramUsername: String,
                        @Json(name = "portfolio_url")
                        val portfolioUrl: String?,
                        @Json(name = "twitter_username")
                        val twitterUsername: String?,
                        @Json(name = "paypal_email")
                        val paypalEmail: String?
                    )
                }
            }

            data class PreviewPhoto(
                @Json(name = "id")
                val id: String,
                @Json(name = "slug")
                val slug: String,
                @Json(name = "created_at")
                val createdAt: String,
                @Json(name = "updated_at")
                val updatedAt: String,
                @Json(name = "blur_hash")
                val blurHash: String,
                @Json(name = "urls")
                val urls: Urls
            ) {
                data class Urls(
                    @Json(name = "raw")
                    val raw: String,
                    @Json(name = "full")
                    val full: String,
                    @Json(name = "regular")
                    val regular: String,
                    @Json(name = "small")
                    val small: String,
                    @Json(name = "thumb")
                    val thumb: String,
                    @Json(name = "small_s3")
                    val smallS3: String
                )
            }
        }
    }
}